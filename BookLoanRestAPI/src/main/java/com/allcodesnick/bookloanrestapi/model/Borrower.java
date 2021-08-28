package com.allcodesnick.bookloanrestapi.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="borrower")
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "shoppingCart",
            joinColumns = @JoinColumn(name = "borrower_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> shoppingCart;

    // Add Book to shopping Cart
    public void addBook(Book book){
        shoppingCart.add(book);
    }

    // Remove Book to shopping Cart
    public void removeBook(Book book) {
        shoppingCart.remove(book);
    }

}
