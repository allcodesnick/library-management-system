package com.allcodesnick.bookloanrestapi.controller;


import com.allcodesnick.bookloanrestapi.model.Book;
import com.allcodesnick.bookloanrestapi.model.Borrower;
import com.allcodesnick.bookloanrestapi.service.BookService;
import com.allcodesnick.bookloanrestapi.service.BorrowerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class BorrowerController {

    private BorrowerService borrowerService;
    private BookService bookService;

    public BorrowerController(BorrowerService borrowerService, BookService bookService
    ) {
        super();
        this.borrowerService = borrowerService;
        this.bookService = bookService;
    }

    /*
        Post RestEndPoints
         */
    @PostMapping("/add")
    public Borrower addBorrower(@RequestBody Borrower borrower){
        return borrowerService.saveBorrower(borrower);
    }
    /*
    Post RestEndPoints add book to shopping Cart
     */
    @PostMapping("/cart/{borrowerId}/{bookId}")
    public Borrower addBookToShoppingCart(@PathVariable long borrowerId, @PathVariable long bookId){
        return borrowerService.addBookToShoppingCart(borrowerId, bookId);
    }

    /*
    Get RestEndPoints
     */
    @GetMapping("/list_all")
    public List<Borrower> getListOfBorrowers(){
        return borrowerService.getListOfBorrowers();
    }

    @GetMapping("id_lookup/{id}")
    public Borrower getBorrowerById(@PathVariable Long id){
        return borrowerService.getBorrowerById(id);
    }

    @GetMapping("email_lookup/{email}")
    public Borrower getBorrowerByEmail(@PathVariable String email){
        return borrowerService.getBorrowerByEmail(email);
    }
    /*
    Put RestEndPoints
     */
    @PutMapping("/update")
    public Borrower updateBorrower(@RequestBody Borrower borrower){
        return borrowerService.updateBorrower(borrower);
    }

    /*
    Delete RestEndPoints
     */
    @DeleteMapping("/delete/{id}")
    public String deleteBorrower(@PathVariable Long id){
        return borrowerService.deleteBorrower(id);
    }

    @DeleteMapping("/cart/delete/{borrowerId}/book/{bookId}")
    public Borrower removeBookFromShoppingCart(@PathVariable Long bookId, @PathVariable Long borrowerId){
        return borrowerService.removeBookFromShoppingCart(borrowerId, bookId);
    }
}
