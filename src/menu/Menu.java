package menu;

import application.Application;
import data.util.DataHelper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

  private Scanner scanner = Application.getScanner();

  public void displayStartMenu() throws IOException {
    String selectNumber;

    while (true) {
      System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――");
      System.out.println("  1. 회원가입   |   2. 로그인   |   3. 종료  ");
      System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――");
      System.out.print("선택> ");
      selectNumber = scanner.nextLine();

      switch (selectNumber) {
        case "1":
          DataHelper dataHelper = DataHelper.getInstance();
          Register register = new Register(new File(dataHelper.getBasicDataDir() + "\\" + "users"));
          register.signUp();
          break;
        case "2":
          return;
        case "3":
          System.out.println("프로그램이 종료됩니다.");
          System.exit(0);
        default:
          System.out.println("제대로 입력하세요.");
      }

    }

  }

}
