package util;

import java.io.File;

public class Utils {
  public static String getDataFolderPath() {
    return new File("").getAbsolutePath() + "/data/";
  }
}
