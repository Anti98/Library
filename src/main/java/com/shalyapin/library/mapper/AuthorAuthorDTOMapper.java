package com.shalyapin.library.mapper;

import com.shalyapin.library.dto.AuthorDTO;
import com.shalyapin.library.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorAuthorDTOMapper   {
    Author AuthorDtoToAuthor(AuthorDTO authorDTO);
    AuthorDTO AuthorToAuthorDto(Author author);

}
