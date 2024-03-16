package com.mert.repository.book;

import com.mert.entity.books.HistoryBook;
import com.mert.repository.book.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import static com.mert.Utility.Database.*;

public class HistoryBookRepository implements BookRepository<HistoryBook> {


    @Override
    public void addBook(HistoryBook entity) {
        historyBookList.add(entity);
    }

    @Override
    public List<HistoryBook>  listByAuthor(String author) {
        return historyBookList
                .stream().filter(book->book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<HistoryBook> listByName(String name) {
        return historyBookList.
                stream().filter(book-> book.getBookName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<HistoryBook> listByISBN(String isbn) {
        return historyBookList.
                stream().filter(book->book.getISBN().toLowerCase().contains(isbn.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<HistoryBook> listAll() {
        return historyBookList;
    }
}
