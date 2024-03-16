package com.mert.repository.book;

import com.mert.entity.books.RomanBook;
import com.mert.repository.book.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import static com.mert.Utility.Database.*;

public class RomanBookRepository implements BookRepository<RomanBook> {
    @Override
    public void addBook(RomanBook entity) {
        romanBookList.add(entity);
    }

    @Override
    public List<RomanBook> listByAuthor(String author) {
        return romanBookList
                .stream().filter(book->book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RomanBook> listByName(String name) {
        return romanBookList.stream()
                .filter(book->book.getBookName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<RomanBook> listByISBN(String isbn) {
        return romanBookList
                . stream().filter(book->book.getISBN().toLowerCase().contains(isbn.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RomanBook> listAll() {
        return romanBookList;
    }
}
