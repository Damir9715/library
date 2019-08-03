package com.example.library.author.api;

import com.example.library.author.dto.AuthorDto;
import com.example.library.author.dto.AuthorDtoMapper;
import com.example.library.author.entity.Author;
import com.example.library.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorDtoMapper authorDtoMapper;

    @GetMapping
    public String getDefString(){
        return "Hello";
    }

    @PostMapping
    public Boolean add(@RequestBody AuthorDto dto){
        try {
            Author entry = authorRepository.save(authorDtoMapper.cast(dto));
            return entry.getId() != null;
        } catch (Exception ex){
            System.out.println(ex);
            return false;
        }
    }
}
