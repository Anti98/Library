package com.shalyapin.library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data

public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

  /*  @ManyToMany(mappedBy = "libraries")*/


    @OneToMany(mappedBy ="library")
    Set<LibraryBook> libraryBooks;
}
