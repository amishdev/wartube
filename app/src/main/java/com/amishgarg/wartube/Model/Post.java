package com.amishgarg.wartube.Model;

public class Post {

    private Author author;
    private String text;
    private String full__url;
    private String full_storage_uri;
    private Object timestamp;
    private int likes;
    private int comments;

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getComments() {
        return comments;
    }

    public int getLikes() {
        return likes;
    }

    public Post(Author author, String text, String full__url, String full_storage_uri, Object timestamp, int likes) {
        this.author = author;
        this.text = text;
        this.full__url = full__url;
        this.full_storage_uri = full_storage_uri;
        this.timestamp = timestamp;
        this.likes = likes;
    }
    public Post()
    {
        //empty cons
    }

    public Post(Author author, String full__url, String text, String full_storage_uri, Object timestamp) {
        this.author = author;
        this.full__url = full__url;
        this.text = text;
        this.full_storage_uri = full_storage_uri;
        this.timestamp = timestamp;
    }

    public Author getAuthor() {
        return author;
    }

    public String getFull__url() {
        return full__url;
    }

    public String getText() {
        return text;
    }

    public String getFull_storage_uri() {
        return full_storage_uri;
    }

    public Object getTimestamp() {
        return timestamp;
    }

//    public void incrementLikes(){
////        likes++;
////    }
}
