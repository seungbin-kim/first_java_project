package board;

import application.Application;
import data.PostList;
import data.read.PostReader;
import data.write.PostWriter;
import exception.LogoutException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Board {

  private String boardName;
  private File boardDir;
  private PostList postList;
  private Scanner scanner = Application.getScanner();


  public Board(String boardName, String dataDir) {
    this.boardName = boardName;
    this.boardDir = new File(dataDir);
    if (!boardDir.exists()) boardDir.mkdirs();

    postList = new PostList(boardDir);
  }


  public void displayBoard() throws IOException, ClassNotFoundException, LogoutException {
    while (true) {
      try {
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println("                        " + boardName);
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("  글번호  |        작성일        |   작성자   |    제목    ");
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        postList.displayList();

        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println("   1. 글 읽기     |     2. 글 쓰기     |     3. 로그아웃   ");
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.print("선택> ");
        select();
      } catch (InputMismatchException e) {
        System.out.println("입력이 잘못되었습니다.");
      } catch (IndexOutOfBoundsException e) {
        System.out.println("존재하지 않는 번호입니다.");
      } catch (NumberFormatException e) {
        System.out.println("제대로 입력하세요.");
      }
    }

  }


  private void select() throws IOException, NumberFormatException, LogoutException {

    String selectNumber = scanner.nextLine();
    switch (selectNumber) {
      case "1":
        new PostReader(postList.getPostList()).readPost();
        break;
      case "2":
        new PostWriter().writePost(boardDir);
        break;
      case "3":
        throw new LogoutException();
      default:
        System.out.println("제대로 입력하세요.");

    }
  }

}
