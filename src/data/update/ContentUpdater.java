package data.update;

import board.Post;

import java.util.Date;

public class ContentUpdater extends PostUpdater {

  public ContentUpdater(Post post) {
    super(post);
  }


  @Override
  public void update() {
    System.out.print("변경할 내용: ");
    targetPost.setContent(scanner.nextLine());
    targetPost.setDate(new Date());
    targetPost.setFileName();
  }

}
