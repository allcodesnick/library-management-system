package com.allcodesnick.bookloanrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "thumbnailUrl", unique = true)
    private String thumbnailUrl;

    private String author;

    private String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "shoppingCart")
    private List<Borrower> borrowers ;

}