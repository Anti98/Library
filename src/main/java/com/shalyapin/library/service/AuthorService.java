package com.shalyapin.library.service;

import com.shalyapin.library.dto.AuthorDTO;
import com.shalyapin.library.entity.Author;
import com.shalyapin.library.exception.AuthorException;
import com.shalyapin.library.mapper.AuthorAuthorDTOMapper;
import com.shalyapin.library.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorService {
   // private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    protected AuthorAuthorDTOMapper mapper;
    public Author createAuthor(AuthorDTO authorDTO){
        return authorRepository.save(mapper.AuthorDtoToAuthor(authorDTO));
    }
    public Author selectAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(()->new AuthorException("No author with that id"));
    }
    public Author updateAuthor(AuthorDTO authorDTO,Long id){
        Author author=mapper.AuthorDtoToAuthor(authorDTO);
        author.setId(id);
        return authorRepository.save(author);
    }
    public Boolean deleteAuthor(Long id){
        authorRepository.findById(id).orElseThrow(()->new AuthorException("No author with that id"));
        authorRepository.deleteById(id);
        return true;
    }

    public List<Author> selectAllAuthor(){
        return authorRepository.findAll();
    }

    public List<Author> selectAuthorByName(String name){
        return authorRepository.findByName(name);
    }
    public List<Author> selectAuthorBySurname(String surName){
        return authorRepository.findBySurName(surName);
    }
    public List<Author> selectAuthorByNameAndSurname(String name,String surName){
        return authorRepository.findAuthorByNameAndSurName(name, surName);
    }
}
