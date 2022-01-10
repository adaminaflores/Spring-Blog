package com.codeup.springblog.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 1000)
    private String email;

    @Column(nullable = false, length = 1000)
    private String password;

    public User(User copy) {
            id = copy.id; // This line is SUPER important! Many things won't work if it's absent
            email = copy.email;
            username = copy.username;
            password = copy.password;
        }

    public User(){}




    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> userPost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getUserPost() {
        return userPost;
    }

    public void setUserPost(List<Post> userPost) {
        this.userPost = userPost;
    }
}
