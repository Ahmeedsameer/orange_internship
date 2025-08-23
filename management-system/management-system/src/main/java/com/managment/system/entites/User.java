  package com.managment.system.entites;

  import jakarta.persistence.Column;
  import jakarta.persistence.Entity;
  import jakarta.persistence.Id;
  import jakarta.persistence.Table;
  import jakarta.persistence.*;


  import java.util.List;

  @Entity
  @Table(name = "users")
  public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column()
  private String user_type;
  @Column(nullable = false)
    private String password;
  @Column(nullable = false)
  private String username;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    List<Task>list;

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    public String getUser_type() {
      return user_type;
    }

    public void setUser_type(String user_type) {
      this.user_type = user_type;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public List<Task> getList() {
      return list;
    }

    public void setList(List<Task> list) {
      this.list = list;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }
