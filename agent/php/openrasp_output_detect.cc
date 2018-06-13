/*
 * Copyright 2017-2018 Baidu Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include "openrasp_security_policy.h"

static void _check_header_content_type_if_html(void *data, void *arg TSRMLS_DC);
static int _detect_param_occur_in_html_output(const char *param TSRMLS_DC);
static bool _gpc_parameter_filter(const zval *param TSRMLS_DC);
static bool _is_content_type_html(TSRMLS_D);

#if (PHP_MAJOR_VERSION == 5) && (PHP_MINOR_VERSION <= 3)

void openrasp_detect_output(INTERNAL_FUNCTION_PARAMETERS)
{
    char *input;
    int input_len;
    long mode;

    if (zend_parse_parameters(ZEND_NUM_ARGS() TSRMLS_CC, "s|l", &input, &input_len, &mode) == FAILURE)
    {
        RETVAL_FALSE;;
    }
    if (_is_content_type_html(TSRMLS_C))
    {
        _detect_param_occur_in_html_output(input TSRMLS_CC);
    }
    RETVAL_FALSE;
}

#else

static php_output_handler *openrasp_output_handler_init(const char *handler_name, size_t handler_name_len, size_t chunk_size, int flags TSRMLS_DC);
static void openrasp_clean_output_start(const char *name, size_t name_len TSRMLS_DC);
static int openrasp_output_handler(void **nothing, php_output_context *output_context);

static int openrasp_output_handler(void **nothing, php_output_context *output_context)
{
    int status = FAILURE;
    PHP_OUTPUT_TSRMLS(output_context);
    if (_is_content_type_html(TSRMLS_C) &&
        (output_context->op & PHP_OUTPUT_HANDLER_START) &&
        (output_context->op & PHP_OUTPUT_HANDLER_FINAL))
    {
        status = _detect_param_occur_in_html_output(output_context->in.data TSRMLS_CC);
    }
    return status;
}

static php_output_handler *openrasp_output_handler_init(const char *handler_name, size_t handler_name_len, size_t chunk_size, int flags TSRMLS_DC)
{
    if (chunk_size)
    {
        return nullptr;
    }
    return php_output_handler_create_internal(handler_name, handler_name_len, openrasp_output_handler, chunk_size, flags TSRMLS_CC);
}

static void openrasp_clean_output_start(const char *name, size_t name_len TSRMLS_DC)
{
    php_output_handler *h;

    if (h = openrasp_output_handler_init(name, name_len, 0, PHP_OUTPUT_HANDLER_STDFLAGS TSRMLS_CC))
    {
        php_output_handler_start(h TSRMLS_CC);
    }
}

#endif

static void _check_header_content_type_if_html(void *data, void *arg TSRMLS_DC)
{
    bool *is_html = static_cast<bool *>(arg);
    if (*is_html)
    {
        sapi_header_struct *sapi_header = (sapi_header_struct *)data;
        static const char *suffix = "Content-type";
        char *header = (char *)(sapi_header->header);
        size_t header_len = strlen(header);
        size_t suffix_len = strlen(suffix);
        if (header_len > suffix_len &&
            strncmp(suffix, header, suffix_len) == 0 &&
            NULL == strstr(header, "text/html"))
        {
            *is_html = false;
        }
    }
}

static bool _gpc_parameter_filter(const zval *param TSRMLS_DC)
{
    return Z_TYPE_P(param) == IS_STRING && Z_STRLEN_P(param) > 10;
}

static int _detect_param_occur_in_html_output(const char *param TSRMLS_DC)
{
    int status = FAILURE;
    if (!PG(http_globals)[TRACK_VARS_GET] &&
        !zend_is_auto_global("_GET", strlen("_GET") TSRMLS_CC) &&
        Z_TYPE_P(PG(http_globals)[TRACK_VARS_GET]) != IS_ARRAY)
    {
        return FAILURE;
    }
    HashTable *ht = Z_ARRVAL_P(PG(http_globals)[TRACK_VARS_GET]);
    for (zend_hash_internal_pointer_reset(ht);
         zend_hash_has_more_elements(ht) == SUCCESS;
         zend_hash_move_forward(ht))
    {
        zval **ele_value;
        if (zend_hash_get_current_data(ht, (void **)&ele_value) != SUCCESS)
        {
            continue;
        }
        if (_gpc_parameter_filter(*ele_value TSRMLS_CC))
        {
            if (NULL != strstr(param, Z_STRVAL_PP(ele_value)))
            {
                char *message = NULL;
                int message_len = spprintf(&message, 0, "%s FOUND IN OUTPUT.", Z_STRVAL_PP(ele_value));
                rasp_info(message, message_len TSRMLS_CC);
                efree(message);
            }
        }
    }
    return status;
}

static bool _is_content_type_html(TSRMLS_D)
{
    bool is_html = true;
    zend_llist_apply_with_argument(&SG(sapi_headers).headers, _check_header_content_type_if_html, &is_html TSRMLS_CC);
    return is_html;
}

PHP_MINIT_FUNCTION(openrasp_output_detect)
{
#if (PHP_MAJOR_VERSION == 5) && (PHP_MINOR_VERSION > 3)
    php_output_handler_alias_register(ZEND_STRL("openrasp_ob_handler"), openrasp_output_handler_init TSRMLS_CC);
#endif
    return SUCCESS;
}

PHP_RINIT_FUNCTION(openrasp_output_detect)
{
#if (PHP_MAJOR_VERSION == 5) && (PHP_MINOR_VERSION <= 3)
    if (php_start_ob_buffer_named("openrasp_ob_handler", 0, 1 TSRMLS_CC) == FAILURE)
    {
        openrasp_error(E_WARNING, RUNTIME_ERROR, _("Failure start OpenRASP output buffering."));
    }
#else
    openrasp_clean_output_start(ZEND_STRL("openrasp_ob_handler") TSRMLS_CC);
#endif
    return SUCCESS;
}