package com.baidu.openrasp.hook.server.weblogic;

import com.baidu.openrasp.hook.server.ServerPreRequestHook;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * @author anyang
 * @Description: TODO
 * @date 2018/8/27 20:09
 */
public class WeblogicPreRequestHook extends ServerPreRequestHook {

    @Override
    public boolean isClassMatched(String className) {
        return "weblogic/servlet/internal/ServletRequestImpl".equals(className);
    }

    @Override
    protected void hookMethod(CtClass ctClass, String src) throws NotFoundException, CannotCompileException {
        insertBefore(ctClass, "run", null, src);
    }
}
