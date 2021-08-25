package com.allcodesnick.bookloanrestapi.controller;


import com.allcodesnick.bookloanrestapi.model.Book;
import com.allcodesnick.bookloanrestapi.model.Borrower;
import com.allcodesnick.bookloanrestapi.service.BookService;
import com.allcodesnick.bookloanrestapi.service.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        super();
        this.bookService = bookService;
    }

    /*
    Post Rest EndPoints
     */
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    /*
    Get Rest EndPoints
     */
    @GetMapping("/list_all")
    public List<Book> getListOfBooks(){
        return bookService.getListBooks();
    }

    @GetMapping("/id_lookup/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/title_lookup/{title}")
    public Book getBookByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/isbn_lookup/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        return bookService.getBookByISBn(isbn);
    }

    /*
    Delete REST EndPoints
     */
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }

    /*
    Update REST EndPoints
     */
    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

}
