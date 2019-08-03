package com.example.library.book.dto;

import com.example.library.book.entity.Book;
import javassist.compiler.ast.Variable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class BookDtoMapper {


    public Book cast(BookDto dto){
        Book entry = new Book();
        entry.setTitle(dto.title);
        entry.setDescription(dto.description);
        return entry;
    }

    public List<BookDto> castDto(List<Book> entry){
        List<BookDto> dto = new ArrayList<BookDto>();
        for(int i=0; i < entry.size();i++){
            dto.add(castDto(entry.get(i)));
        }
        return dto;
    }

    public BookDto castDto(Book entry){
        BookDto dto = new BookDto();
        dto.id = entry.getId();
        dto.title = entry.getTitle();
        dto.description = entry.getDescription();
        return dto;
    }
}
