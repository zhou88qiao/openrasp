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

package com.baidu.openrasp.hook.server.weblogic;

import com.baidu.openrasp.hook.AbstractClassHook;
import com.baidu.openrasp.tool.Reflection;
import com.baidu.openrasp.tool.annotation.HookAnnotation;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @program openrasp
 * @description: weblogic的xss检测hook点
 * @author: anyang
 * @create: 2018/09/05 15:06
 */
public class WeblogicXssHook extends AbstractClassHook {
    @Override
    public boolean isClassMatched(String className) {
        return "weblogic/servlet/internal/CharsetChunkOutput".equals(className);
    }

    @Override
    public String getType() {
        return "xss";
    }

    @Override
    protected void hookMethod(CtClass ctClass) throws IOException, CannotCompileException, NotFoundException {
        String src = getInvokeStaticSrc(WeblogicXssHook.class, "getWeblogicOutputBuffer", "$0", Object.class);
        insertBefore(ctClass, "flush", "()V", src);
    }

    public static void getWeblogicOutputBuffer(Object object){
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Reflection.getField(object,"buf");
            String content = new String(byteBuffer.array());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
