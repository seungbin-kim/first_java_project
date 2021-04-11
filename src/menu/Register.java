package menu;

import application.Application;
import data.util.DataHelper;
import data.util.DataHandler;
import users.User;

import java.io.*;
import java.util.Scanner;

public class Register {

  private File dataDir;
  private Scanner scanner = Application.getScanner();
  private DataHelper dataHelper = DataHelper.getInstance();
  private DataHandler dataHandler = DataHandler.getInstance();

  public Register(File dataDir) {
    this.dataDir = dataDir;
  }

  public void signUp() throws IOException {
    dataHelper.dirCheck(dataDir);

    System.out.println("----------------------------");
    System.out.println("           회원가입           ");
    System.out.println("----------------------------");
    String id = inputId();
    String password = inputPassword();

    dataHandler.dataSerialize(new User(id, password), dataHelper.getDataPath(dataDir, id));
    System.out.println("등록 완료!");
  }


  private String inputId() {
    String id;

    System.out.print("원하는 ID를 입력해 주세요: ");
    while (true) {
      id = scanner.nextLine();
      if (!dataHelper.isExistId(id)) {
        break;
      }
      System.out.print("ID가 중복됩니다. 다시 입력해 주세요: ");
    }
    System.out.println();

    return id;
  }


  private String inputPassword() {
    String password1;
    String password2;

    while (true) {
      System.out.print("원하는 비밀번호: ");
      password1 = scanner.nextLine();

      System.out.print("비밀번호 확인: ");
      password2 = scanner.nextLine();

      if (isPasswordEquals(password1, password2)){
        break;
      }
      System.out.println("비밀번호가 틀립니다.!");
    }
    System.out.println();

    return password1;
  }


  private boolean isPasswordEquals(String password1, String password2) {
    return password1.equals(password2);
  }


}
