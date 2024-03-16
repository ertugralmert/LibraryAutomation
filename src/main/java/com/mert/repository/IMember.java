package com.mert.repository;

import com.mert.entity.Member;
import com.mert.entity.books.Book;

import java.util.List;

public interface IMember {

    String addMember(Member member);
    Member login(String email, String password);

    boolean rentBook(String bookName, String memberIdentity);

    boolean returnBook(String bookName,String memberIdentity);

    List<Book> listRantedBooks(String identity);





}
