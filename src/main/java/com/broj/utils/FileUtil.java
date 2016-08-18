package com.broj.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by seal on 8/9/16.
 */
public class FileUtil {

    public static boolean checkPath(String path) {
        return Files.exists(Paths.get(path));
    }

    public static void createDir(String path) {
        try {
            File file = new File(path);
            if (isDirExists(path)) {
                    FileUtils.cleanDirectory(file);
                    FileUtils.forceDelete(file);
            }
            FileUtils.forceMkdir(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFileName(String path) {
        return Paths.get(path).getFileName().toString();
    }

    public static boolean isDirExists(String path) {
        return Files.exists(Paths.get(path));
    }

    public static String getParent(String path) {
        return new File(path).getParent();
    }
}
