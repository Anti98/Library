package com.shalyapin.library.mapper;

import com.shalyapin.library.dto.BookDTO;
import com.shalyapin.library.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookBookDTOMapper {
    BookDTO BookToBookDTO(Book book);
    Book BookDTOTOBook(BookDTO bookDTO);
}
