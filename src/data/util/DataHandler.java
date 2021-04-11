package data.util;

import java.io.*;

public class DataHandler {

  private static DataHandler singleton = new DataHandler();
  private FileInputStream fis;
  private ObjectInputStream ois;


  private DataHandler() {
  }


  public static DataHandler getInstance() {
    return singleton;
  }


  public <T> void dataSerialize(T data, String dataPath) throws IOException {
    FileOutputStream fos = new FileOutputStream(dataPath);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(data);
    oos.flush();
    oos.close();
    fos.close();
  }


  public Object dataUnserialize(String dataPath) throws IOException, ClassNotFoundException {
    fis = new FileInputStream(dataPath);
    ois = new ObjectInputStream(fis);
    Object returnObject = ois.readObject();

    fis.close();
    ois.close();
    return returnObject;
  }

}
