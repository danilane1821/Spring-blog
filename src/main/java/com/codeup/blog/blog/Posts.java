package com.codeup.blog.blog;

public class Posts {
    protected long id;
    private String title;
    private String body;

    public Posts(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Posts(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
