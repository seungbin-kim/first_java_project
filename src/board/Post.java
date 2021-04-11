package board;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post implements Serializable {

  private static final long serialVersionUID = 2L;

  private String title;
  private String writer;
  private Date date;
  private String content;
  private File boardDir;
  private String fileName;

  public Post(String title, String writer, Date date, String content, File boardDir) {
    this.title = title;
    this.writer = writer;
    this.date = date;
    this.content = content;
    this.boardDir = boardDir;
    setFileName();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getWriter() {
    return writer;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public File getBoardDir() {
    return boardDir;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    this.fileName = sdf.format(this.date);
  }

}
