package data.read;

import application.Application;
import data.update.ContentUpdater;
import data.delete.PostRemover;
import data.update.PostUpdater;
import data.update.TitleUpdater;
import exception.WriterMismatchException;
import board.Post;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PostReader {

  private List<Post> postList;
  private Scanner scanner = Application.getScanner();


  public PostReader(List<Post> postList) {
    this.postList = postList;
  }


  public void readPost() throws IndexOutOfBoundsException, IOException, NumberFormatException, NullPointerException {
    Post targetPost;
    String selectNumber;
    PostUpdater postUpdater;

    System.out.print("몇 번째 글을 읽을까요?> ");
    selectNumber = scanner.nextLine();

    targetPost = postList.get(postList.size() - Integer.parseInt(selectNumber));

    System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
    System.out.println("제목: " + targetPost.getTitle());
    System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
    System.out.println(targetPost.getContent());
    System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
    System.out.println(" 1. 제목 수정 | 2. 내용 수정 | 3. 글 삭제 |  4. 목록으로 가기  ");
    System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
    System.out.print("선택> ");
    selectNumber = scanner.nextLine();

    try {
      switch (selectNumber) {
        case "1":
          checkWriter(targetPost.getWriter());
          postUpdater = new TitleUpdater(targetPost);
          break;
        case "2":
          checkWriter(targetPost.getWriter());
          postUpdater = new ContentUpdater(targetPost);
          break;
        case "3":
          checkWriter(targetPost.getWriter());
          PostRemover postRemover = new PostRemover();
          postRemover.deletePost(targetPost);
          return;
        case "4":
          return;
        default:
          System.out.println("제대로 입력하세요.");
          return;
      }

      postUpdater.updatePost();
    } catch (WriterMismatchException e) {
      System.out.println("글 작성자가 아닙니다.");
    }
  }


  private boolean isWriter(String postWriter) {
    String currentUserId = Application.getCurrentUser().getId();
    if (currentUserId.equals(postWriter)) {
      return true;
    }

    return false;
  }


  private void checkWriter(String postWriter) throws WriterMismatchException {
    if (isWriter(postWriter)) {
      return;
    }
    throw new WriterMismatchException();
  }

}
