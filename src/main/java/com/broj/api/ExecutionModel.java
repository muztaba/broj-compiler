package com.broj.api;

/**
 * Created by seal on 8/18/16.
 */
public class ExecutionModel extends AbstractModel {

    private final String lang;
    private final String workingDir;
    private final String inputFilePath;
    private final String outputFilePath;

    public ExecutionModel(String lang, String workingDir, String inputFilePath, String outputFilePath) {
        this.lang = lang;
        this.workingDir = workingDir;
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    @Override
    public String getWorkingDir() {
        return workingDir;
    }

    @Override
    public String getSrcPath() {
        return null;
    }

    @Override
    public String getLang() {
        return lang;
    }

    @Override
    public String getInputFilePath() {
        return inputFilePath;
    }

    @Override
    public String getOutputFilePath() {
        return outputFilePath;
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
