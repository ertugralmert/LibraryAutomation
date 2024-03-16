package com.mert.repository.book;

import com.mert.entity.books.ScienceBook;
import com.mert.repository.book.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import static com.mert.Utility.Database.*;

public class ScienceBookRepository implements BookRepository<ScienceBook> {
    @Override
    public void addBook(ScienceBook entity) {
        scienceBookList.add(entity);
    }

    @Override
    public List<ScienceBook> listByAuthor(String author) {
        return scienceBookList
                .stream().filter(book->book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScienceBook> listByName(String name) {
        return scienceBookList
                .stream().filter(book-> book.getBookName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScienceBook> listByISBN(String isbn) {
        return scienceBookList
                .stream().filter(book->book.getISBN().toLowerCase().contains(isbn.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScienceBook> listAll() {
        return scienceBookList;
    }
}
