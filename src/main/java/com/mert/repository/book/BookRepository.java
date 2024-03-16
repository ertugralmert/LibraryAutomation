package com.mert.repository.book;

import com.mert.entity.books.HistoryBook;

import java.util.List;

public interface BookRepository<T> {

    /*
    -> Listeleme
    -> Ekleme
    -> Arama
        -> ISBN göre arama
        -> isme göre arama
        -> yazara göre arama
     */


  void addBook(T entity);

  List<T> listByAuthor(String author);
  List<T>  listByName(String name);
  List<T>  listByISBN(String isbn);

  List<T> listAll();

}
