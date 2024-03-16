package com.mert.service.book;

import com.mert.entity.books.HistoryBook;
import com.mert.repository.book.BookRepository;

import java.util.List;

public class HistoryBookService implements BookService<HistoryBook> {

    private final BookRepository bookRepository;

    public HistoryBookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @Override
    public void add(HistoryBook entity) {
        bookRepository.addBook(entity);
    }

    @Override
    public List<HistoryBook> listByAuthor(String author) {
        return bookRepository.listByAuthor(author);
    }

    @Override
    public List<HistoryBook> listByName(String name) {
        return bookRepository.listByName(name);
    }

    @Override
    public List<HistoryBook> listByISBN(String isbn) {
        return bookRepository.listByISBN(isbn);
    }

    @Override
    public List<HistoryBook> listAll() {
        return bookRepository.listAll();
    }
}
