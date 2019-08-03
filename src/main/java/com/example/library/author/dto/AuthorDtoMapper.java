package com.example.library.author.dto;

import com.example.library.author.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorDtoMapper {
    public Author cast(AuthorDto dto){
        Author entry = new Author();
        entry.setFirstName(dto.firstName);
        entry.setLastName(dto.lastName);
        return entry;
    }

    public AuthorDto castDto(Author entry){
        AuthorDto dto = new AuthorDto();
        dto.id = entry.getId();
        dto.firstName = entry.getFirstName();
        dto.lastName = entry.getLastName();
        return dto;
    }
}
