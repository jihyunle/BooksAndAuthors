package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String city;
//    @ManyToMany
//    private Set<Book> books;
    @OneToMany(mappedBy = "book")
    private Set<BooksAndAuthors> books;

    public Author(){
        books = new HashSet<>();

    }

    public Author(String name, String city) {
        books = new HashSet<>();
//        this.name = name;
        this.setName(name);
//        this.city = city;
        this.setCity(city);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<BooksAndAuthors> getBooks() {
        return books;
    }

    public void setBooks(Set<BooksAndAuthors> books) {
        this.books = books;
    }

    //    public Set<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(Set<Book> books) {
//        this.books = books;
//    }
}
