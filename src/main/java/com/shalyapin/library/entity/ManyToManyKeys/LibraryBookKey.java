package com.shalyapin.library.entity.ManyToManyKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class LibraryBookKey implements Serializable {
    @Column(name ="book_id" )
    private Long bookId;
    @Column(name = "library_id")
    private Long libraryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryBookKey that = (LibraryBookKey) o;
        return bookId.equals(that.bookId) && libraryId.equals(that.libraryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, libraryId);
    }
}
