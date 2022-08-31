package com.shalyapin.library.repository;

import com.shalyapin.library.entity.Book;
import com.shalyapin.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface LibraryRepository  extends JpaRepository<Library,Long> {
public List<Library> findByName(String name);
}
