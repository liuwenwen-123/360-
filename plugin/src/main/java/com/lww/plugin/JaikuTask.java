package com.lww.plugin;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecSpec;

import java.io.File;

import javax.inject.Inject;

public class JaikuTask extends DefaultTask {

    File file;
    JiaGuExt jiaGuExt;
    @Inject
    public JaikuTask(File apk,JiaGuExt jiaGuExt) {
        setGroup("task");
        this.file=apk;
        this.jiaGuExt=jiaGuExt;
    }
//   表示 我们点击gradle 中的 jiagutask  时 就会 执行
    @TaskAction
    public  void  jiagu(){
        System.out.println(  "  a  aaaaaaaa  ");
//  完成加固
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
//  登录 360
                execSpec.commandLine("java","-version",
                        jiaGuExt.getJiaguToolsPath(),"-login",jiaGuExt.getUsername(),
                        jiaGuExt.getUserpwd());
            }
        });
// 导入签名
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {

                execSpec.commandLine("java","-jar",
                        jiaGuExt.getJiaguToolsPath(),"-importsign",
                        jiaGuExt.getKeyStorePath(),
                        jiaGuExt.getKeyStorePwd(),
                        jiaGuExt.getKeyStoreAlias(),
                        jiaGuExt.getKeyStoreAliasPwd() );
            }
        });
//        加固
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {

                execSpec.commandLine("java","-jar",
                        jiaGuExt.getJiaguToolsPath(),"-jiagu",
                        file.getAbsoluteFile(),
                        file.getParent(),
                        jiaGuExt.getKeyStoreAlias(),
                         "-autosign");
            }
        });
    }

}
