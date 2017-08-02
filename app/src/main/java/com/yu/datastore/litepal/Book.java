package com.yu.datastore.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by D22436 on 2017/8/2.
 * litepal 操作的实体类，进行crud需要继承DataSupport
 */

public class Book extends DataSupport{
    private String name;
    private String author;
    private float price;
    private int pages;

    public Book() {
    }

    public Book(String name, String author, float price, int pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                '}';
    }
}
