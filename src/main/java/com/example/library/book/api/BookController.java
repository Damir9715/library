package com.example.library.book.api;

import com.example.library.book.dto.BookDto;
import com.example.library.book.dto.BookDtoMapper;
import com.example.library.book.entity.Book;
import com.example.library.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookDtoMapper bookDtoMapper;

    @GetMapping
    public List<BookDto> getDefString(){
        return bookDtoMapper.castDto((List<Book>) bookRepository.findAll());
    }

    @PostMapping
    public Boolean add(@RequestBody BookDto dto){
        try {
            Book entry = bookRepository.save(bookDtoMapper.cast(dto));
            return entry.getId() != null;
        } catch (Exception ex){
            System.out.println(ex);
            return false;
        }
    }
}
