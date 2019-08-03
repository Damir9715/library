package com.example.library.book.repository;

import com.example.library.book.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {

}
