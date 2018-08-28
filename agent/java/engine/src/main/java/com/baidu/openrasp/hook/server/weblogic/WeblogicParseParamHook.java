package com.baidu.openrasp.hook.server.weblogic;

import com.baidu.openrasp.hook.server.ServerParamHook;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * @author anyang
 * @Description: TODO
 * @date 2018/8/27 16:40
 */
public class WeblogicParseParamHook extends ServerParamHook {

    @Override
    public boolean isClassMatched(String className) {
        return "weblogic/servlet/internal/ServletRequestImpl$RequestParameters".equals(className);
    }

    @Override
    protected void hookMethod(CtClass ctClass, String src) throws NotFoundException, CannotCompileException {
        insertBefore(ctClass, "parseQueryParams", null, src);
        insertBefore(ctClass,"parseExtraQueryParams",null,src);
    }

}
