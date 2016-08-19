package com.broj.api;

/**
 * Created by seal on 8/18/16.
 */
public class CompileModel extends AbstractModel {

    private final String workingDir;
    private final String srcPath;
    private final String lang;

    public CompileModel(String lang, String workingDir, String srcPath) {
        this.lang = lang;
        this.workingDir = workingDir;
        this.srcPath = srcPath;

    }

    @Override
    public String getWorkingDir() {
        return workingDir;
    }

    @Override
    public String getSrcPath() {
        return srcPath;
    }

    @Override
    public String getLang() {
        return lang;
    }

    @Override
    public String getInputFilePath() {
        return null;
    }

    @Override
    public String getOutputFilePath() {
        return null;
    }

    @Override
    public String getParent() {
        return null;
    }

    @Override
    public long getTimeLimit() {
        return 0;
    }
}
