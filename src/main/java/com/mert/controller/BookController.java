package com.mert.controller;

import java.util.Scanner;

public abstract class BookController<T> {
protected      Scanner scanner = new Scanner(System.in);
private String isbn;
private String name;
private String author;
private  int yearReleased;

public abstract void addBook();
public abstract void listByAuthor();
public abstract void listByName();

public abstract void listByISBN();

public abstract void listAll();

protected String inputLine(String input){
    System.out.println(input);
    return scanner.nextLine();
}

protected int inputInt(String input){
    System.out.println(input);
    int into = scanner.nextInt();
    scanner.nextLine();
    return into;
}




}
