package com.mert.controller;

import com.mert.entity.Member;
import com.mert.entity.books.Book;
import com.mert.service.book.MemberService;

import java.util.List;
import java.util.Scanner;

public class MemberController {
    Scanner scanner = new Scanner(System.in);

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }



    public void addMember(){
        System.out.println("Aşağıdaki bilgileri doldurunuz");
       String name= informationScanner("Üye ad: ");
       String lastname = informationScanner("Üye Soyadı: ");
       String identity = informationScanner("TcNo: ");
       String email = informationScanner("Email: ");
       String password = informationScanner("Password: ");
       Member member = new Member(name,lastname,identity,email,password);

        System.out.println(memberService.addMember(member));
    }
    public boolean  login(){
        System.out.println("Giriş Yapmak için bilgileri giriniz");
        String email = informationScanner("Email: ");
        String password = informationScanner("Password: ");
        Member member = memberService.login(email,password);
        if(member != null){
            System.out.println("Giriş başarılı. Hoş Geldiniz,".concat(member.getName()).concat(" !"));
            return true;
        }else {
            System.out.println("Giriş başarısız. E-psta veya password hatalı");
            return false;
        }
    }
    public void rentBook(){
        System.out.println("Kiralama işlemi");
        String bookName = informationScanner("Kitap Adı: ");
        String memberIdentity = informationScanner("TcNo: ");
        boolean check = memberService.rentBook(bookName,memberIdentity);
        if(check){
            System.out.println(bookName + " isimli kitap başarılı bir şekilde kiralandı");
        } else {
            System.out.println("Kiralama işlemi başarısız");
        }
    }
    public void returnBook(){
        System.out.println("İade İşlemi");
        String bookName = informationScanner("Kitap ismi: ");
        String memberIdentity = informationScanner("TcNo: ");
        boolean check = memberService.returnBook(bookName,memberIdentity);
        if(check){
            System.out.println(bookName + " isimli kitap başarılı bir şekilde iade edildi");
        } else {
            System.out.println("Iade işlemi başarısız, tekrar deneyin.");
        }
    }
    public List<Book> listRantedBooks(){
        String identity = informationScanner("Tc NO: ");
        System.out.println(identity + " tarafından kiralanan kitaplar");
        return memberService.listRantedBooks(identity);
    }


    private String informationScanner(String input){
        System.out.println(input);
        return scanner.nextLine();
    }
}
