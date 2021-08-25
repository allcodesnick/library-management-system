package com.allcodesnick.bookloanrestapi.service.impl;

import com.allcodesnick.bookloanrestapi.model.Book;
import com.allcodesnick.bookloanrestapi.model.Borrower;
import com.allcodesnick.bookloanrestapi.repository.BorrowerRepository;
import com.allcodesnick.bookloanrestapi.service.BookService;
import com.allcodesnick.bookloanrestapi.service.BorrowerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    private BorrowerRepository borrowerRepository;
    private BookService bookService;

    public BorrowerServiceImpl(BorrowerRepository borrowerRepository, BookService bookService) {
        super();
        this.borrowerRepository = borrowerRepository;
        this.bookService = bookService;
    }
    /*
        Post Methods
         */
    @Override
    public Borrower saveBorrower(Borrower borrower){
        return borrowerRepository.save(borrower);
    }

    /*
    Get Methods
     */
    @Override
    public List<Borrower> getListOfBorrowers(){
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower getBorrowerById(Long id){
        return borrowerRepository.findById(id).orElse(null);
    }
    @Override
    public Borrower getBorrowerByEmail(String email){
        return borrowerRepository.findByEmail(email);
    }
    /*
    Delete Methods
     */
    @Override
    public String deleteBorrower(Long id){
        borrowerRepository.deleteById(id);
        return "Borrower Removed! Id: " + id;
    }
    /*
    Update Methods
     */
    @Override
    public Borrower updateBorrower(Borrower borrower){
        Borrower existingBorrower = borrowerRepository.findById(borrower.getId()).orElse(null);
        existingBorrower.setFirstName(borrower.getFirstName());
        existingBorrower.setLastName(borrower.getLastName());
        existingBorrower.setEmail(borrower.getEmail());
        existingBorrower.setPhoneNo(borrower.getPhoneNo());
        return borrowerRepository.save(existingBorrower);
    }

    /*
    Adding and Deleting Book to Shopping Cart(Post/Delete)
     */
    @Override
    public Borrower addBookToShoppingCart(Long borrowerId, Long bookId){
        Borrower borrower = getBorrowerById(borrowerId);
        Book book = bookService.getBookById(bookId);
        borrower.addBook(book);
        return borrowerRepository.save(borrower);
    }
    @Override
    public Borrower removeBookFromShoppingCart(Long borrowerId, Long bookId){
        Borrower borrower = getBorrowerById(borrowerId);
        Book book = bookService.getBookById(bookId);
        borrower.removeBook(book);
        return borrowerRepository.save(borrower);
    }
}
