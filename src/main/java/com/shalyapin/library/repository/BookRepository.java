package com.shalyapin.library.repository;

import com.shalyapin.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByTitle(String name);
    List<Book> findByAuthor_Id(Long author_id);

    List<Book>findByTitleAndAuthor_Id(String title,Long author_id);

}
