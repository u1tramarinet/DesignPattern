package builder;

import java.io.File;

public class FilePathUtils {

    private FilePathUtils() {
    }

    public static String getDataPath() {
        String path = new File(".").getAbsoluteFile().getParent();
        return path + "\\data";
    }
}
