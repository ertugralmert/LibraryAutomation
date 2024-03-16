package com.mert.controller;

import com.mert.Utility.Situation;
import com.mert.entity.books.HistoryBook;
import com.mert.repository.book.HistoryBookRepository;
import com.mert.service.book.BookService;
import com.mert.service.book.HistoryBookService;

import java.util.List;

public class HistoryBookController  extends BookController{

    private final BookService bookService;

    public HistoryBookController(BookService bookService){
        this.bookService = new HistoryBookService(new HistoryBookRepository());

    }


    @Override
    public void addBook() {
        String isbn = inputLine("Kitap ISBN: ");
        String name = inputLine("Kitap ismi: ");
        String author = inputLine("Yazar ismi: ");
        int yearReleased = inputInt("Yayın Yılı: ");
        HistoryBook book = new HistoryBook(isbn,name,author,yearReleased, Situation.Rentable);
        bookService.add(book);
        System.out.println(name.concat(" isimli kitap başarılı bir şekilde eklendi"));
    }

    @Override
    public void listByAuthor() {
        String author = inputLine("Aramak istediğiniz kitabın yazarını giriniz: ");
        List<HistoryBook> books = bookService.listByAuthor(author);
        System.out.println("Bulunan kitap sayısı: "+ books.size());
        books.forEach(book-> System.out.println(book.toString()));
        if(books.isEmpty()){
            System.out.println("Bu yazarın kitap(lar)'ı sistemde mevcut değil");
        }

    }

    @Override
    public void listByName() {
        String name = inputLine("Aramak istediğiniz kitap ismini giriniz: ");
        List<HistoryBook> books = bookService.listByName(name);
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
        List<HistoryBook> books = bookService.listAll();
        System.out.println("MEvcut kitap sayısı: "+ books.size());
        books.forEach(book-> System.out.println(book.toString()));
        if(books.isEmpty()){
            System.out.println("Sistemde mevcut kitap yok");
        }
    }
}
