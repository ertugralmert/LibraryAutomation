package com.mert.service.book;

import com.mert.entity.Member;
import com.mert.entity.books.Book;
import com.mert.repository.MemberRepository;

import java.util.List;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public String addMember(Member member){
        return memberRepository.addMember(member);
    }

    public Member login(String email, String password){
        return memberRepository.login(email,password);
    }

    public boolean rentBook(String bookName, String memberIdentity){
        return memberRepository.rentBook(bookName,memberIdentity);
    }

    public boolean returnBook(String bookName, String memberIdentity){
        return memberRepository.returnBook(bookName,memberIdentity);
    }

    public List<Book> listRantedBooks(String identity){
        return memberRepository.listRantedBooks(identity);
    }
}
