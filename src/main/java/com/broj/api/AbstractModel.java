package com.broj.api;

import com.broj.utils.FileUtil;

/**
 * Created by seal on 8/18/16.
 */
public abstract class AbstractModel {

    public abstract String getWorkingDir();

    public abstract String getSrcPath();

    public abstract String getLang();

    public abstract String getInputFilePath();

    public abstract String getOutputFilePath();

    public abstract long getTimeLimit();

    public String getParent() {
        return FileUtil.getParent(getSrcPath());
    }

    public String getFileName(boolean var) {
        String f = null;
        if (var)
            f = FileUtil.getFileName(getSrcPath());
        else
            f = FileUtil.fileNameWithoutExtension(getSrcPath());
        return f;
    }


}
