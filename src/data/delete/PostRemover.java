package data.delete;

import data.util.DataHelper;
import board.Post;

import java.io.File;

public class PostRemover {

  public void deletePost(Post targetPost) {
    DataHelper dataHelper = DataHelper.getInstance();
    String targetPostPath = dataHelper.getDataPath(targetPost.getBoardDir(), targetPost.getFileName());

    File file = new File(targetPostPath);
    file.delete();
  }

}
