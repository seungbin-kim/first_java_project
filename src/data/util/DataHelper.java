package data.util;

import java.io.File;

public class DataHelper {

  private static DataHelper singleton = new DataHelper();
  private String basicDataDir = "C:\\Users\\seungbin\\Personal_Project\\data";


  private DataHelper() {
  }


  public static DataHelper getInstance() {
    return singleton;
  }


  public String getBasicDataDir() {
    return basicDataDir;
  }


  public boolean isExistId(String id) {
    File[] files = new File(basicDataDir + "\\users").listFiles();

    for (File file : files) {
      if (file.getName().equals(id + ".db")) return true;
    }

    return false;
  }


  public void dirCheck(File dataDir) {
    if (!dataDir.exists()) {
      dataDir.mkdirs();
    }
  }


  public String getDataPath(File dataDir, String fileName) {
    return dataDir.getPath() + "\\" + fileName + ".db";
  }

}
