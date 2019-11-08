package com.codeup.blog.blog;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "Int(11) UNSIGNED",nullable = false)
    private long id;

    @Column(nullable = false, length = 200)
    private String username;

    @Column(nullable = false, length = 400)
    private String email;

    @Column(nullable = false, length = 200)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public List<Post> getPosts (){
        return posts;
    }

    public void setPosts() {
        this.posts = posts;
    }

}
