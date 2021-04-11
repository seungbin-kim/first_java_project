package data;

import data.util.DataHandler;
import board.Post;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class PostList {

  private File boardPath;
  private List<Post> postList = new ArrayList<>();
  private DataHandler dataHandler = DataHandler.getInstance();
  private int postNumber;


  public PostList(File boardPath) {
    this.boardPath = boardPath;
  }


  public void displayList() {
    postList.clear();
    readList();

    if (!checkPosts()) {
      return;
    }

    postNumber = postList.size();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    Stream<Post> stream = postList.stream();
    stream.forEach(post -> {
      System.out.println(
          "\t" + postNumber + "     " + sdf.format(post.getDate()) +
              "  \t" + post.getWriter() + "\t" + post.getTitle());
      postNumber--;
    });
  }


  public void readList() {
    File[] files = boardPath.listFiles();

    Arrays.stream(files)
        .sorted(Comparator.reverseOrder())
        .forEach(file -> {
          try {
            postList.add((Post) dataHandler.dataUnserialize(file.getPath()));
          } catch (IOException | ClassNotFoundException e) {
            System.out.println("파일 읽기중 에러.");
          }
        });

  }


  public boolean checkPosts() {
    if (postList.isEmpty()) {
      System.out.println("게시글이 없습니다.");
      return false;
    }
    return true;
  }


  public List<Post> getPostList() {
    return postList;
  }

}
