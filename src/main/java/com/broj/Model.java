package com.broj;


import com.broj.utils.IOUtils;

/**
 * Created by seal on 8/9/16.
 */
public class Model {

    public final String language;
    public final String srcPath;
    public final String inputPath;
    public final String resultFilePath;

    private String fileName;
    private String fileNameWithoutExtension;

    private Model(String language, String srcPath, String inputPath, String resultFilePath) {
        this.language = language.trim().toLowerCase();
        this.srcPath = srcPath.trim();
        this.inputPath = inputPath.trim();
        this.resultFilePath = resultFilePath.trim();
    }

    public static Model getModel(String[] args) {
        if (args.length != 4)
            throw new RuntimeException("args is not in correct length " + args.length);

        Model model = new Model(args[0], args[1], args[2], args[3]);
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
                    (fileName = IOUtils.getFileName(srcPath));
            f = fileName;
        } else {
            if (fileNameWithoutExtension == null) {
                String[] strings = getFileName(true).split("\\.");
                fileNameWithoutExtension = strings[0];
            }
            f = fileNameWithoutExtension;
        }
        return f;
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
        if (!IOUtils.checkPath(filePath))
            throw new RuntimeException("File is not in place at = " + filePath);
    }
}
