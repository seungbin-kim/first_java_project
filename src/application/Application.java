package application;

import data.util.DataHelper;
import exception.LogoutException;
import menu.Login;
import menu.Menu;
import board.Board;
import users.User;

import java.io.IOException;
import java.util.Scanner;

public class Application {

  private static Scanner scanner = new Scanner(System.in);
  private static User currentUser;

  public static void main(String[] args) {
    Menu menu = new Menu();

    while (true) {
      try {
        menu.displayStartMenu();

        DataHelper dataHelper = DataHelper.getInstance();
        Login login = new Login(dataHelper.getBasicDataDir() + "\\users");

        currentUser = login.signIn();

        Board board = new Board("자유게시판", dataHelper.getBasicDataDir() + "\\board");
        board.displayBoard();
      } catch (IOException | ClassNotFoundException e) {
        System.out.println("입출력중 에러. 다시 시도해 주세요.");
      } catch (NumberFormatException e) {
        System.out.println("제대로 입력하세요.");
      } catch (LogoutException e) {
        currentUser = null;
        System.out.println("로그아웃 되었습니다.");
      }
    }


  }

  public static Scanner getScanner() {
    return scanner;
  }

  public static User getCurrentUser() {
    return currentUser;
  }

}
