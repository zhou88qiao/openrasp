package com.baidu.openrasp.hook.server.weblogic;

import com.baidu.openrasp.hook.AbstractClassHook;
import com.baidu.openrasp.tool.Reflection;
import com.baidu.openrasp.tool.StackTrace;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @description: weblogic控制台登录弱口令检查
 * @author: anyang
 * @create: 2018/09/06 20:19
 */
public class WeblogicConsolePasswordChecker extends AbstractClassHook {
    @Override
    public boolean isClassMatched(String className) {
        return "weblogic/servlet/internal/WebAppServletContext".equals(className);
    }

    @Override
    public String getType() {
        return "weblogicConsolePassword";
    }

    @Override
    protected void hookMethod(CtClass ctClass) throws IOException, CannotCompileException, NotFoundException {
        String src = getInvokeStaticSrc(WeblogicConsolePasswordChecker.class, "checkConsolePassword", "$1", Object.class);
        insertBefore(ctClass, "securedExecute", null, src);
    }

    public static void checkConsolePassword(Object request){
        Map<String,String[]> map = (Map<String,String[]>) Reflection.invokeMethod(request,"getParameterMap",new Class[]{});
    }
}
