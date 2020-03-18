package util;

import java.io.File;

public class FilePathUtils {

    public static final String SLASH = "\\";

    private FilePathUtils() {
    }

    public static String getDataPath() {
        return getPath("data");
    }

    public static String getSrcPath() {
        return getPath("src");
    }

    public static String getOutPath() {
        return getPath("data" + SLASH + "out");
    }

    private static String getPath(String folderName) {
        String path = new File(".").getAbsoluteFile().getParent();
        return path + SLASH + folderName + SLASH;
    }
}
