package com.broj;

import com.broj.api.AbstractModel;
import com.broj.utils.FileUtil;

import java.io.File;

/**
 * Created by seal on 8/9/16.
 */

public class ProcessBuilderFactory {

    public static ProcessBuilder getProcessBuilder(AbstractModel model) {
        ProcessBuilder processBuilder = null;
        String lang = model.getLang();
        String compiledPath = model.getWorkingDir();
        String srcPath = model.getSrcPath();

        switch (lang) {
            case Language.CPP :
                String str = compiledPath + model.getFileName(false);
                processBuilder = new ProcessBuilder("g++", srcPath, "-o", str);
                break;
            case Language.JAVA :
                processBuilder = new ProcessBuilder("javac", "-d", compiledPath, srcPath);
                break;
        }

        return processBuilder;
    }

    public static ProcessBuilder getExecutionProcessBuilder(AbstractModel model) {
        ProcessBuilder processBuilder = null;
        String lang = model.getLang();
        String fileName = model.getFileName(false);

        switch (lang) {
            case Language.CPP :
                processBuilder = new ProcessBuilder("./" + fileName);
                break;
            case Language.JAVA :
                processBuilder = new ProcessBuilder("java", "-cp", ".", fileName);
                break;
        }

        return processBuilder;
    }

}
