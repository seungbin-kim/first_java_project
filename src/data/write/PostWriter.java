package data.write;

import application.Application;
import data.util.DataHandler;
import data.util.DataHelper;
import board.Post;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class PostWriter {

  public void writePost(File boardDir) throws IOException {
    Scanner scanner = Application.getScanner();
    String title;
    String writer = Application.getCurrentUser().getId();
    String content;

    DataHelper dataHelper = DataHelper.getInstance();
    DataHandler dataHandler = DataHandler.getInstance();

    System.out.print("제목: ");
    title= scanner.nextLine();

    System.out.print("내용: ");
    content = scanner.nextLine();

    Post post = new Post(title, writer, new Date(), content, boardDir);
    dataHandler.dataSerialize(post, dataHelper.getDataPath(boardDir, post.getFileName()));
    System.out.println("글쓰기 성공!");
  }


}
