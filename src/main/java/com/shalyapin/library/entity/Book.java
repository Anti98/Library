package com.shalyapin.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
   // @JsonIgnore
    private Author author;
    private String edition;
    /*@ManyToMany()
    @JoinTable(
        name = "Book_Library",
        joinColumns = @JoinColumn(name="book_id"),
        inverseJoinColumns = @JoinColumn(name = "library_id"))
        */
    @OneToMany(mappedBy ="book")
    private Set<LibraryBook> libraryBooks;

}
