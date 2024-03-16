package com.mert.controller;

import com.mert.Utility.Situation;
import com.mert.entity.books.HistoryBook;
import com.mert.entity.books.ScienceBook;
import com.mert.repository.book.RomanBookRepository;
import com.mert.repository.book.ScienceBookRepository;
import com.mert.service.book.BookService;
import com.mert.service.book.RomanBookService;
import com.mert.service.book.ScienceBookService;

import java.util.List;

public class ScienceBookController extends BookController {

    private final BookService bookService;

    public ScienceBookController (BookService bookService){
        this.bookService = new ScienceBookService(new ScienceBookRepository());
    }
    @Override
    public void addBook() {
        String isbn = inputLine("Kitap ISBN: ");
        String name = inputLine("Kitap ismi: ");
        String author = inputLine("Yazar ismi: ");
        int yearReleased = inputInt("Yayın Yılı: ");
        ScienceBook book = new ScienceBook(isbn,name,author,yearReleased, Situation.Rentable);
        bookService.add(book);
        System.out.println(name.concat(" isimli kitap başarılı bir şekilde eklendi"));
    }

    @Override
    public void listByAuthor() {
        String author = inputLine("Aramak istediğiniz kitabın yazarını giriniz: ");
        List<ScienceBook> books = bookService.listByAuthor(author);
        System.out.println("Bulunan kitap sayısı: "+ books.size());
        books.forEach(book-> System.out.println(book.toString()));
        if(books.isEmpty()){
            System.out.println("Bu yazarın kitap(lar)'ı sistemde mevcut değil");
        }
    }

    @Override
    public void listByName() {
        String name = inputLine("Aramak istediğiniz kitap ismini giriniz: ");
        List<ScienceBook> books = bookService.listByName(name);
        System.out.println("Bulunan kitap sayısı: "+ books.size());
        books.forEach(book-> System.out.println(book.toString()));
        if(books.isEmpty()){
            System.out.println("Kitaplar sistemde mevcut değil");
        }
    }

    @Override
    public void listByISBN() {
        String isbn = inputLine("Aramak istediğiniz ISBN numarasını giriniz: ");
        List<HistoryBook> books = bookService.listByISBN(isbn);
        System.out.println("Bulunan kitap sayısı: "+ books.size());
        books.forEach(book-> System.out.println(book.toString()));
        if(books.isEmpty()){
            System.out.println("Bu ISBN sahip kitap sistemde mevcut değil");
        }
    }

    @Override
    public void listAll() {
        List<ScienceBook> books = bookService.listAll();
        System.out.println("MEvcut kitap sayısı: "+ books.size());
        books.forEach(book-> System.out.println(book.toString()));
        if(books.isEmpty()){
            System.out.println("Sistemde mevcut kitap yok");
        }
    }
    }

