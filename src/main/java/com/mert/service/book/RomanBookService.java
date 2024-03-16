package com.mert.service.book;

import com.mert.entity.books.RomanBook;
import com.mert.repository.book.BookRepository;
import com.mert.service.book.BookService;

import java.util.List;

public class RomanBookService implements BookService<RomanBook> {
    private final BookRepository bookRepository;

    public RomanBookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public void add(RomanBook entity) {
        bookRepository.addBook(entity);
    }

    @Override
    public List<RomanBook> listByAuthor(String author) {
        return bookRepository.listByAuthor(author);
    }

    @Override
    public List<RomanBook> listByName(String name) {
        return bookRepository.listByName(name);
    }

    @Override
    public List<RomanBook> listByISBN(String isbn) {
        return bookRepository.listByISBN(isbn);
    }

    @Override
    public List<RomanBook> listAll() {
        return bookRepository.listAll();
    }
}
