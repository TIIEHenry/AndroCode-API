package androcode.api.file;

import java.io.File;

public class FileUtils {

    public static String getSuffix(File file) {
        return file.getPath().substring(file.getPath().lastIndexOf(".") + 1);
    }
}
