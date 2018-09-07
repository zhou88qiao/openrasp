package com.baidu.openrasp.hook.server.weblogic;

import com.baidu.openrasp.HookHandler;
import com.baidu.openrasp.hook.server.ServerInputHook;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;

/**
 * @author anyang
 * @Description: 获取weblogic的请求body
 * @date 2018/8/27 20:29
 */
public class WeblogicHttpInputHook extends ServerInputHook {

    @Override
    public boolean isClassMatched(String className) {
        return "weblogic/servlet/internal/ServletInputStreamImpl".equals(className);
    }

    @Override
    protected void hookMethod(CtClass ctClass) throws IOException, CannotCompileException, NotFoundException {
        String srcRead1 = getInvokeStaticSrc(HookHandler.class, "onInputStreamRead",
                "$_,$0", int.class, Object.class);
        insertAfter(ctClass, "read", "()I", srcRead1);
        String srcRead2 = getInvokeStaticSrc(HookHandler.class, "onInputStreamRead",
                "$_,$0,$1", int.class, Object.class, byte[].class);
        insertAfter(ctClass, "read", "([B)I", srcRead2);
        String srcRead3 = getInvokeStaticSrc(HookHandler.class, "onInputStreamRead",
                "$_,$0,$1,$2,$3", int.class, Object.class, byte[].class, int.class, int.class);
        insertAfter(ctClass, "read", "([BII)I", srcRead3);
    }
}
