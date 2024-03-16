package com.mert.entity;


import com.mert.entity.books.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member {

    String id;
    String name;
    String lastname;
    String identity;
    String email;
    String password;

    List<Book> rentedBooks = new ArrayList<>();


    public Member(String name, String lastname, String identity, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.identity = identity;
        this.email = email;
        this.password = password;
        this.rentedBooks = rentedBooks;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(List<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Member{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", identity='").append(identity).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", rentedBooks=").append(rentedBooks);
        sb.append('}');
        return sb.toString();
    }
}
