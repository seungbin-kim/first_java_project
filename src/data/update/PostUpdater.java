package data.update;

import application.Application;
import data.delete.PostRemover;
import data.util.DataHandler;
import data.util.DataHelper;
import board.Post;

import java.io.IOException;
import java.util.Scanner;

public abstract class PostUpdater {

  protected Scanner scanner = Application.getScanner();
  protected Post targetPost;


  public PostUpdater(Post post) {
    this.targetPost = post;
  }


  public void updatePost() throws IOException {
    DataHandler dataHandler = DataHandler.getInstance();
    DataHelper dataHelper = DataHelper.getInstance();
    PostRemover postRemover = new PostRemover();
    postRemover.deletePost(targetPost);

    update();
    dataHandler.dataSerialize(targetPost,
        dataHelper.getDataPath(targetPost.getBoardDir(), targetPost.getFileName()));
  }


  public abstract void update();

}
