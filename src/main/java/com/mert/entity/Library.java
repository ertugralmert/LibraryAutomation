package com.mert.entity;

import com.mert.controller.*;
import com.mert.entity.books.Book;
import com.mert.repository.MemberRepository;
import com.mert.repository.book.HistoryBookRepository;
import com.mert.repository.book.RomanBookRepository;
import com.mert.repository.book.ScienceBookRepository;
import com.mert.service.book.HistoryBookService;
import com.mert.service.book.MemberService;
import com.mert.service.book.RomanBookService;
import com.mert.service.book.ScienceBookService;

import java.util.Scanner;

public class Library {

    private final String admin = "admin";
    private final String password = "passw0rd";

 private    Book book;
  private   Member member;

public     BookController historyController = new HistoryBookController(new HistoryBookService(new HistoryBookRepository()));
 public    BookController romanController = new RomanBookController(new RomanBookService(new RomanBookRepository()));

   public BookController scienceController = new ScienceBookController(new ScienceBookService(new ScienceBookRepository()));

  public   MemberController memberController = new MemberController(new MemberService(new MemberRepository()));

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Library() {
    }

    public String getAdmin() {
        return admin;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Library{");
        sb.append("admin='").append(admin).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", book=").append(book);
        sb.append(", member=").append(member);
        sb.append('}');
        return sb.toString();
    }

    public boolean loginAsAdmin(String user, String password){
        return this.admin.equals(user)&&this.password.equals(password);
    }

    // Book Side

    // History Books
    public void addHistoryBook(){
        historyController.addBook();
    }

    public void searchByNameHistory(){
        historyController.listByName();
    }

    public void searchByAuthorHistory(){
        historyController.listByAuthor();
    }

    public void searchByISBNHistory(){
        historyController.listByISBN();
    }

    // Science Books

    public void addScienceBook(){
        scienceController.addBook();
    }

    public void searchByNameScience(){
        scienceController.listByName();
    }

    public void searchByAuthorScience(){
        scienceController.listByAuthor();
    }

    public void searchByISBNScience(){
        scienceController.listByISBN();
    }


    // Roman Books
    public void addRomanBook(){
        romanController.addBook();
    }

    public void searchByNameRoman(){
        romanController.listByName();
    }

    public void searchByAuthorRoman(){
        romanController.listByAuthor();
    }

    public void searchByISBNRoman(){
        romanController.listByISBN();
    }

    // Member

    public void addMember(){
        memberController.addMember();
    }

    public void rentBook(){
        memberController.rentBook();
    }

    public void returnBook(){
        memberController.returnBook();
    }

    public void listRantedBooks(){
        memberController.listRantedBooks();
    }

    public boolean loginMember(){
     return   memberController.login();
    }


}
