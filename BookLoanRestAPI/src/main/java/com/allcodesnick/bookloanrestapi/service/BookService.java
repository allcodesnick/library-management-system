package com.allcodesnick.bookloanrestapi.service;

import com.allcodesnick.bookloanrestapi.model.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    List<Book> getListBooks();

    Book getBookById(Long id);

    Book getBookByTitle(String title);

    Book getBookByISBn(String isbn);

    String deleteBook(Long id);

    Book updateBook(Book book);

}
