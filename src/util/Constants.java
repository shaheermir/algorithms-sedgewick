package util;

import java.io.File;

public class Constants {
    public static String getDataFolderPath() {
        return new File("").getAbsolutePath() + "/data/";
    }

}
