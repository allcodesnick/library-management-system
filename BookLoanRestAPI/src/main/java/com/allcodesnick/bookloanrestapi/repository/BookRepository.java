package com.allcodesnick.bookloanrestapi.repository;

import com.allcodesnick.bookloanrestapi.model.Book;
import com.allcodesnick.bookloanrestapi.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Book findByIsbn(String isbn);

}
