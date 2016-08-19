package com.broj;


import com.broj.api.AbstractModel;
import com.broj.utils.FileUtil;
import lombok.*;

/**
 * Created by seal on 8/9/16.
 */


public class Model extends AbstractModel{

    private final String language;
    private final String srcPath;
    private final String inputPath;
    private final String resultFilePath;
    private final long timeLimit;
    private final String workingDir;

    @Setter(AccessLevel.PRIVATE) @Getter(AccessLevel.PRIVATE)
    private String fileName;

    @Getter(AccessLevel.PRIVATE) @Setter(AccessLevel.PRIVATE)
    private String fileNameWithoutExtension;

    private Model(String language, String srcPath, String inputPath, String resultFilePath, String timeLimit, String workingDir) {
        this.language = language.trim().toLowerCase();
        this.srcPath = srcPath.trim();
        this.inputPath = inputPath.trim();
        this.resultFilePath = resultFilePath.trim();
        this.timeLimit = Long.parseLong(timeLimit.trim());
        this.workingDir = workingDir;
    }

    public static Model getModel(String... args) {
        if (args.length != 6)
            throw new RuntimeException("args is not in correct length " + args.length);

        Model model = new Model(args[0], args[1], args[2], args[3], args[4], args[5]);
        model.validate();
        return model;
    }

    /**
     * @param var is 'true' the return String with file extension and
     *            return only file name otherwise.
     * @return file name with or without extension depending on var.
     */
    public String getFileName(boolean var) {
        String f = null;
        if (var) {
            fileName = fileName != null ? fileName :
                    (fileName = FileUtil.getFileName(srcPath));
            f = fileName;
        } else {
            if (fileNameWithoutExtension == null) {
                fileNameWithoutExtension = FileUtil.fileNameWithoutExtension(srcPath);
            }
            f = fileNameWithoutExtension;
        }
        return f;
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
        return language;
    }

    @Override
    public String getInputFilePath() {
        return inputPath;
    }

    @Override
    public String getOutputFilePath() {
        return resultFilePath;
    }

    @Override
    public String getParent() {
        return FileUtil.getParent(srcPath);
    }

    @Override
    public long getTimeLimit() {
        return timeLimit;
    }

    private void validate() {
        languageCheck(language);
        pathCheck(srcPath);
        pathCheck(inputPath);
        pathCheck(resultFilePath);
    }

    private void languageCheck(String lang) {
        if (!Language.isThere(lang))
            throw new RuntimeException("Language parameter is not set : " + lang);
    }

    private void pathCheck(String filePath) {
        if (!FileUtil.checkPath(filePath))
            throw new RuntimeException("File is not in place at = " + filePath);
    }
}
