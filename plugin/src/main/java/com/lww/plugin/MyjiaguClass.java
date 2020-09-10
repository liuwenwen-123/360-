package com.lww.plugin;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;
import com.android.build.gradle.api.BaseVariant;
import com.android.build.gradle.api.BaseVariantOutput;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;

import java.io.File;

public class MyjiaguClass implements Plugin<Project> {


    @Override
    public void apply(Project project) {
        final JiaGuExt jiagu = project.getExtensions().create("Myjiagu", JiaGuExt.class);
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(final Project project) {
                System.out.println(jiagu.getUsername());
                AppExtension appExtension = project.getExtensions().getByType(AppExtension.class);
//         得到一个集合  默认获取  debug  和release
                appExtension.getApplicationVariants().all(new Action<ApplicationVariant>() {
                    @Override
                    public void execute(ApplicationVariant applicationVariant) {

                        applicationVariant.getOutputs().all(new Action<BaseVariantOutput>() {
                            @Override
                            public void execute(BaseVariantOutput baseVariantOutput) {
//                                需要加固的  文件
                                File outputFile = baseVariantOutput.getOutputFile();
                                String name = baseVariantOutput.getName();
                                project.getTasks().create("jiagu" + name, JaikuTask.class,
                                        outputFile,jiagu);
                            }
                        });
                    }
                });
            }
        });


    }
}