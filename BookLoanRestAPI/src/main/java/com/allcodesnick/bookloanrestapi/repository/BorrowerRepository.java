package com.allcodesnick.bookloanrestapi.repository;

import com.allcodesnick.bookloanrestapi.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    Borrower findByEmail(String email);
}
