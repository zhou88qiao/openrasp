package com.baidu.openrasp.plugin.checker.local;

import com.baidu.openrasp.config.Config;
import com.baidu.openrasp.plugin.checker.AttackChecker;
import com.baidu.openrasp.plugin.checker.CheckParameter;
import com.baidu.openrasp.plugin.info.AttackInfo;
import com.baidu.openrasp.plugin.info.EventInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: weblogic控制台弱口令检查
 * @author: anyang
 * @create: 2018/09/10 15:04
 */
public class WeblogicConsoleChecker extends AttackChecker {
    private static List<String> checkList = new ArrayList<String>();
    static {
        checkList.add("weblogic");
        checkList.add("weblogic1");
        checkList.add("12345678");
    }

    public WeblogicConsoleChecker(boolean canBlock) {
        super(canBlock&& Config.getConfig().getEnforcePolicy());
    }

    @Override
    public List<EventInfo> checkParam(CheckParameter checkParameter) {
        LinkedList<EventInfo> result = new LinkedList<EventInfo>();
        String password = (String) checkParameter.getParam("password");
        if (password != null) {
            if (checkList.contains(password)) {
                result.add(AttackInfo.createLocalAttackInfo(checkParameter, EventInfo.CHECK_ACTION_BLOCK, "The weblogic console password strength is weak, please change the password."));
            }
        }
        return result;
    }
}
