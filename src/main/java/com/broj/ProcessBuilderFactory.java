package com.broj;

import com.broj.utils.IOUtils;

import java.nio.file.Paths;

/**
 * Created by seal on 8/9/16.
 */
public class ProcessBuilderFactory {

    public static ProcessBuilder getProcessBuilder(String lang, String srcPath, String compiledPath) {
        ProcessBuilder processBuilder = null;

        switch (lang) {
            case Language.CPP :
                String str = compiledPath + "/" + IOUtils.getFileName(srcPath);
                processBuilder = new ProcessBuilder("g++", srcPath, "-o", compiledPath);
                break;
            case Language.JAVA :
                processBuilder = new ProcessBuilder("javac", "-d", compiledPath, srcPath);
                break;
        }

        return processBuilder;
    }

    public static ProcessBuilder getExecutionProcessBuilder(String lang, String fileName) {
        ProcessBuilder processBuilder = null;

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
