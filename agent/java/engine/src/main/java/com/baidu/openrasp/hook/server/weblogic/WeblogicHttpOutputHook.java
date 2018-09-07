package com.baidu.openrasp.hook.server.weblogic;

import com.baidu.openrasp.hook.server.ServerOutputCloseHook;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * @program openrasp
 * @description: 插入用户自定义脚本
 * @author: anyang
 * @create: 2018/09/05 13:54
 */
public class WeblogicHttpOutputHook extends ServerOutputCloseHook {


    @Override
    public boolean isClassMatched(String className) {
        return "weblogic/servlet/internal/ServletOutputStreamImpl".equals(className);
    }

    @Override
    protected void hookMethod(CtClass ctClass, String src) throws NotFoundException, CannotCompileException {
        insertBefore(ctClass, "finish", "()V", src);
    }
}
