package data.update;

import board.Post;

import java.util.Date;

public class TitleUpdater extends PostUpdater {

  public TitleUpdater(Post post) {
    super(post);
  }


  @Override
  public void update() {
    System.out.print("변경할 제목: ");
    targetPost.setTitle(scanner.nextLine());
    targetPost.setDate(new Date());
    targetPost.setFileName();
  }

}
