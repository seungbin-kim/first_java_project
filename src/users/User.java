package users;

import java.io.Serializable;

public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String password;


  public User(String id, String password) {
    this.id = id;
    this.password = password;
  }


  public String getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

}
