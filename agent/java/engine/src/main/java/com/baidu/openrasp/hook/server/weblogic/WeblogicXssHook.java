package com.baidu.openrasp.hook.server.weblogic;

import com.baidu.openrasp.hook.AbstractClassHook;
import com.baidu.openrasp.tool.Reflection;
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
