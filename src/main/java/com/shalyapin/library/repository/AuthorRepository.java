package com.shalyapin.library.repository;

import com.shalyapin.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findByName(String name);  // Как можно без создания метода в репозитории ?
    List<Author> findBySurName(String surname);
    List<Author> findAuthorByNameAndSurName(String name,String surname);

}
