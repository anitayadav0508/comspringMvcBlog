package com.springMvc.blog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "bookdetail")
public class BookDetail implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
//    because it's receiving end so add join column
    private Book book;
    @Column(name = "title")
    private String title;
    @Column(name = "no_of_pages")
    private Integer no_of_pages;



//    bookDetail sends the data


    public BookDetail() {
    }

    public BookDetail(String title, Integer no_of_pages) {
        this.title = title;
        this.no_of_pages = no_of_pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNo_of_pages() {
        return no_of_pages;
    }

    public void setNo_of_pages(Integer no_of_pages) {
        this.no_of_pages = no_of_pages;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookDetail{" +
                "book=" + book +
                ", title='" + title + '\'' +
                ", no_of_pages=" + no_of_pages +
                '}';
    }
}
