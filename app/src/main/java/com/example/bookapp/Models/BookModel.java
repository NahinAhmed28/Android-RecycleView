package com.example.bookapp.Models;

public class BookModel {
    int image;
    String bookName;

    public BookModel(int image, String bookName) {
        this.image = image;
        this.bookName = bookName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
