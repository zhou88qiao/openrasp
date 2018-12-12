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

package com.baidu.rasp.install;

import com.baidu.rasp.App;
import com.baidu.rasp.RaspError;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static com.baidu.rasp.RaspError.E10003;

/**
 * Created by OpenRASP on 5/10/17.
 * All rights reserved
 */
public abstract class BaseStandardInstaller implements Installer {
    private String serverName;
    private String serverRoot;
    public static String resinPath;
    public static int NOTFOUND = 0;
    public static int FOUND = 1;
    public static int DONE = 2;
    public static String LINE_SEP = System.getProperty("line.separator");

    public BaseStandardInstaller(String serverName, String serverRoot) {
        this.serverName = serverName;
        this.serverRoot = serverRoot;
        resinPath = serverRoot;
    }

    @Override
    public void install() throws RaspError, IOException {
        String jarPath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        File srcDir = new File(new File(jarPath).getParent() + File.separator + "rasp");
        if (!(srcDir.exists() && srcDir.isDirectory())) {
            srcDir = new File("rasp");
        }
        File installDir = new File(getInstallPath(serverRoot));

        if (!srcDir.getCanonicalPath().equals(installDir.getCanonicalPath())) {
            // 拷贝rasp文件夹
            System.out.println("Duplicating \"rasp\" directory\n- " + installDir.getCanonicalPath());
            FileUtils.copyDirectory(srcDir, installDir);
        }

        System.out.println("Make \"rasp\" directory writable\n");
        modifyFolerPermission(installDir.getCanonicalPath());

        // 生成配置文件
        if (!generateConfig(installDir.getPath())) {
            System.exit(1);
        }

        // 找到要修改的启动脚本
        File script = new File(getScript(installDir.getPath()));
        if (!script.exists()) {
            throw new RaspError(E10003 + script.getAbsolutePath());
        }

        // 修改服务器启动脚本
        System.out.println("Updating startup script\n- " + script.getCanonicalPath());
        String original = read(script);
        String modified = modifyStartScript(original);
        write(script, modified);
        System.out.println("\nInstallation completed without errors.\nPlease restart application server to take effect.");
    }


    private boolean generateConfig(String dir) {
        try {
            String sep = File.separator;
            File target = new File(dir + sep + "conf" + sep + "rasp.yaml");

            System.out.println("Generating \"rasp.properties\"\n- " + target.getAbsolutePath());
            if (target.exists() && App.keepConfig) {
                System.out.println("- Already exists and reserved rasp.properties, continuing ..");
                return true;
            }
            if (target.exists()) {
                File reserve = new File(dir + sep + "conf" + sep + "rasp.properties.bak");
                if (!reserve.exists()) {
                    reserve.createNewFile();
                }
                FileOutputStream outputStream = new FileOutputStream(reserve);
                FileInputStream inputStream = new FileInputStream(target);
                IOUtils.copy(inputStream, outputStream);
                outputStream.close();
                inputStream.close();
                System.out.println("- Backed up rasp.properties to rasp.properties.bak");
            } else {
                System.out.println("- Create " + target.getAbsolutePath());
                target.getParentFile().mkdir();
                target.createNewFile();
            }
            FileWriter writer = new FileWriter(target);
            InputStream is = this.getClass().getResourceAsStream("/rasp.yaml");
            IOUtils.copy(is, writer, "UTF-8");
            is.close();
            writer.close();

            //配置云控参数
            setCloudArgs(App.url, App.appId, App.appSecret);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public static String read(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        return new String(data);
    }

    public static void write(File file, String content) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        writer.write(content);
        writer.close();
    }

    public static String runCommand(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec(args);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null) {
                sb.append(line).append("\n");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (IOException e) {
            return "";
        }
    }

    public static void modifyFolerPermission(String folderPath) {
        if (System.getProperty("os.name").startsWith("Windows")) {
            String res = runCommand(new String[]{"cmd", "/c", "echo Y|%SYSTEMROOT%\\System32\\cacls \"" + folderPath + "\" /G everyone:F"});
            // System.out.println(res);
        } else {
            if (System.getProperty("user.name").equals("root")) {
                runCommand(new String[]{"chmod", "-R", "o+w", folderPath});
            }
        }
    }

    private void setCloudArgs(String url, String appId, String appSecret) {
        try {
            if (url != null && appId != null && appSecret != null) {
                String path = getInstallPath(serverRoot) + File.separator + "conf" + File.separator + "rasp.yaml";
                File yamlFile = new File(path);
                if (yamlFile.exists()) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("cloud.enable", true);
                    map.put("cloud.address", url);
                    map.put("cloud.appid", appId);
                    map.put("cloud.appsecret", appSecret);
                    FileWriter writer = new FileWriter(yamlFile, true);
                    writer.write(LINE_SEP);
                    writer.write("#云控配置");
                    writer.write(LINE_SEP);
                    DumperOptions options = new DumperOptions();
                    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
                    options.setPrettyFlow(true);
                    Yaml yaml = new Yaml(options);
                    yaml.dump(map, writer);
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to update rasp.yaml: failed to add cloud control settings: " + e.getMessage());
        }
    }

    protected abstract String getInstallPath(String serverRoot);

    protected abstract String getScript(String installPath);

    protected abstract String modifyStartScript(String content) throws RaspError;
}
