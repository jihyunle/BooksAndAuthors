package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String genre;
    private String publisher;
//    @ManyToMany(mappedBy = "books")
//    private Set<Author> authors;
    @OneToMany(mappedBy = "author")
    private Set<BooksAndAuthors> authors;

    /*DEBUG Notes:
    * "mappedBy reference an unknown target entity property"
    * Once you create BooksAndAuthors join class,
    * make sure the mappedBy reference signals to that class
    * I had it set as
    * private Set<Author> authors in Book class and
    * private Set<Book> books in Author class*/

    public Book(){
        authors = new HashSet<>();

    }

    public Book(String title, String genre, String publisher) {
        authors = new HashSet<>();
        this.setTitle(title);
        this.setGenre(genre);
        this.setPublisher(publisher);
//        this.title = title;
//        this.genre = genre;
//        this.publisher = publisher;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<BooksAndAuthors> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<BooksAndAuthors> authors) {
        this.authors = authors;
    }

    //    public Set<Author> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(Set<Author> authors) {
//        this.authors = authors;
//    }
}
