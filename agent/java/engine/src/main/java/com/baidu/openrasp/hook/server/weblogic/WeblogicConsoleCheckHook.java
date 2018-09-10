package com.baidu.openrasp.hook.server.weblogic;

import com.baidu.openrasp.HookHandler;
import com.baidu.openrasp.hook.AbstractClassHook;
import com.baidu.openrasp.plugin.checker.CheckParameter;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.*;

/**
 * @description: weblogic控制台登录弱口令检查
 * @author: anyang
 * @create: 2018/09/06 20:19
 */
public class WeblogicConsoleCheckHook extends AbstractClassHook {
    @Override
    public boolean isClassMatched(String className) {
        return "weblogic/servlet/security/internal/SecurityModule".equals(className);
    }

    @Override
    public String getType() {
        return "weblogicConsole";
    }

    @Override
    protected void hookMethod(CtClass ctClass) throws IOException, CannotCompileException, NotFoundException {
        String src = getInvokeStaticSrc(WeblogicConsoleCheckHook.class, "checkConsolePassword", "$5", Object.class);
        insertBefore(ctClass, "checkAuthenticate", null, src);
    }

    public static void checkConsolePassword(Object password){
        if (password!=null){
            HashMap<String, Object> params = new HashMap<String, Object>(1);
            params.put("password",password);
            HookHandler.doCheckWithoutRequest(CheckParameter.Type.WEBLOGIC_CONSOLE,params);
        }
    }
}
