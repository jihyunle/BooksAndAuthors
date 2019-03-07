package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BooksAndAuthorsRepository booksAndAuthorsRepository;

    Author author;
    Book book;
    BooksAndAuthors booksAndAuthors;
    Set<BooksAndAuthors> books;

    @RequestMapping("/")
    public String index(Model model){
        // create an author
        author = new Author("JK Rowling", "London");
        // create a book
        book = new Book("Harry Potter and the Deathly Hollows", "Fiction", "English Book Housing");
        // create a booksAndAuthors
        booksAndAuthors = new BooksAndAuthors(author, book);
        // add book to an empty list
        books = new HashSet<>();

        books.add(booksAndAuthors);
        // save the book to the db
        bookRepository.save(book);
        // add list of books to author's book list
        author.setBooks(books);
        // save the author to the db
        authorRepository.save(author);
//        // save the book to the db
//        bookRepository.save(book);

        /* DEBUG NOTES:
        "object references an unsaved transient instance"
        book may not be saved yet
        moved the above statement, (bookRepository.save(book), further up, and now
        it saves the book to bookSet, then add book to bookRepo,
        then saves the bookSet to author, then saves author to authorRepo*/

        // grab all the authors from db and send to template
        model.addAttribute("authors", authorRepository.findAll());

        // grab all the books from db and send to template
        model.addAttribute("books", bookRepository.findAll());
        return "list";

    }



}
