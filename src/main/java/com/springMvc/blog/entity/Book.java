package com.springMvc.blog.entity;

import javax.persistence.*;
import java.io.Serializable;



/*One to One Mapping

        1)shared primary key
        2)with foreign key

Book refer to tail  so need joinColumn
BookDetail refer to Head need to add mappedBy*/
@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "book",cascade = CascadeType.ALL)
    //its sending data so add mapped by
    private BookDetail bookDetail;

//    for fetching data from db
    public Book() {
    }

//    for inserting data to db
    public Book(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookDetail=" + bookDetail +
                '}';
    }
}
