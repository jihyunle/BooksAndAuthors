package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface BooksAndAuthorsRepository extends CrudRepository<BooksAndAuthors,Long> {
}
