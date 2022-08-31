package com.shalyapin.library.entity;

import com.shalyapin.library.entity.ManyToManyKeys.LibraryBookKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LibraryBook {
    @EmbeddedId
    LibraryBookKey id;
    @ManyToOne
    @MapsId("libraryId")
    @JoinColumn(name ="library_id")
    Library library;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    Book book;

    int Count;
}
