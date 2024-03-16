package com.mert.service.book;

import com.mert.entity.books.ScienceBook;
import com.mert.repository.book.BookRepository;
import com.mert.service.book.BookService;

import java.util.List;

public class ScienceBookService implements BookService<ScienceBook> {
    private final BookRepository bookRepository;

    public ScienceBookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void add(ScienceBook entity) {
        bookRepository.addBook(entity);
    }

    @Override
    public List<ScienceBook> listByAuthor(String author) {
        return bookRepository.listByAuthor(author);
    }

    @Override
    public List<ScienceBook> listByName(String name) {
        return bookRepository.listByName(name);
    }

    @Override
    public List<ScienceBook> listByISBN(String isbn) {
        return bookRepository.listByISBN(isbn);
    }

    @Override
    public List<ScienceBook> listAll() {
        return bookRepository.listAll();
    }
}
