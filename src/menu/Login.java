package menu;

import application.Application;
import data.util.DataHandler;
import data.util.DataHelper;
import exception.IdNotFoundException;
import users.User;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Login {

  private File dataDir;
  private Scanner scanner = Application.getScanner();
  private DataHelper dataHelper = DataHelper.getInstance();
  private DataHandler dataHandler = DataHandler.getInstance();


  public Login(String dataDir) {
    this.dataDir = new File(dataDir);
  }


  public User signIn() throws IOException, ClassNotFoundException {
    dataHelper.dirCheck(dataDir);

    System.out.println("――――――――――――――――――――――――――――――――――――");
    System.out.println("            로그인            ");
    System.out.println("――――――――――――――――――――――――――――――――――――");

    return authenticate();
  }


  private User authenticate() throws IOException, ClassNotFoundException {

    String id;
    String password;
    User user;
    boolean correctId;
    boolean correctPw = false;

    while (true) {
      try {
        System.out.print("ID: ");
        id = scanner.nextLine();
        if (dataHelper.isExistId(id)){
          correctId = true;
        }
        else {
          throw new IdNotFoundException("ID 불일치");
        }

        System.out.print("Password: ");
        password = scanner.nextLine();
        user = (User) dataHandler.dataUnserialize(dataHelper.getDataPath(dataDir, id));
        if (user.getPassword().equals(password)){
          correctPw = true;
        }

        if (correctId && correctPw){
          break;
        }

        System.out.println("로그인 정보가 틀립니다.");
      } catch (IdNotFoundException e) {
        System.out.println(e.getMessage());
      }
    }

    System.out.println("로그인 성공!");
    return user;
  }

}
