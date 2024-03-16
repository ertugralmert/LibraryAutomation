package com.mert.service.book;

import java.util.List;

public interface BookService<T> {

    public void add(T entity);

    List<T> listByAuthor(String author);

    List<T> listByName(String name);

    List<T> listByISBN(String isbn);

    List<T> listAll();


}
