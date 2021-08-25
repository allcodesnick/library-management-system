package com.allcodesnick.bookloanrestapi.service.impl;

import com.allcodesnick.bookloanrestapi.model.Book;
import com.allcodesnick.bookloanrestapi.repository.BookRepository;
import com.allcodesnick.bookloanrestapi.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository){
        super();
        this.bookRepository = bookRepository;
    }

    /*
    Post Method
     */
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /*
    Get Methods
     */
    @Override
    public List<Book> getListBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book getBookByISBn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    /*
    Delete Methods
     */
    @Override
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Book Removed! Id: " + id;
    }

    /*
    Update Methods
     */
    @Override
    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).orElse(null);
        existingBook.setTitle(book.getTitle());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setThumbnailUrl(book.getThumbnailUrl());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setCategory(book.getCategory());
        return bookRepository.save(existingBook);
    }

}
