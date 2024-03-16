package com.mert.repository;

import com.mert.Utility.Situation;
import com.mert.entity.Member;
import com.mert.entity.books.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.mert.Utility.Database.*;

public class MemberRepository implements IMember {


    @Override
    public String addMember(Member member) {
        boolean check = memberList.stream().anyMatch(x -> x.getIdentity().equals(member.getIdentity()) && x.getEmail().equals(member.getEmail()));
        if (!check) {
            memberList.add(member);
            return "Ekleme İşlemi Başarılı";
        } else
            return "Uye sistemde mevcut";


    }

    @Override
    public Member login(String email, String password) {
        return memberList.stream()
                .filter(x -> x.getEmail().equalsIgnoreCase(email)
                        && x.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    @Override
    public boolean rentBook(String bookName, String memberIdentity) {
        Optional<Member> memberOptional = memberList.stream()
                .filter(x -> x.getIdentity().equals(memberIdentity)).findFirst();
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            Optional<Book> bookOptional = findBookByName(bookName);

            if (bookOptional.isPresent() || bookOptional.get().getSituation() != Situation.Rentable) {
                Book book = bookOptional.get();
                book.setSituation(Situation.Rented);
                member.getRentedBooks().add(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean returnBook(String bookName, String memberIdentity) {
        Optional<Member> memberOptional = memberList.stream()
                .filter(x -> x.getIdentity().equals(memberIdentity)).findFirst();
        if (memberOptional.isPresent()) {

            Member member = memberOptional.get();
            Optional<Book> bookOptional = member.getRentedBooks().stream()
                    .filter(x -> x.getBookName().equalsIgnoreCase(bookName)).findFirst();
            if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setSituation(Situation.Rentable);
            member.getRentedBooks().remove(book);
            return true;
        }
    }
        return false;
}

    @Override
    public List<Book> listRantedBooks(String identity) {

      Member member =  memberList.stream()
                .filter(x->x.getIdentity().equals(identity)).findFirst().orElse(null);
      if(member != null){
          return member.getRentedBooks();
      }
         return new ArrayList<>();
    }

    private Optional<Book> findBookByName(String bookName){
       List<Book> allBooks = new ArrayList<>();
       allBooks.addAll(historyBookList);
       allBooks.addAll(romanBookList);
       allBooks.addAll(scienceBookList);
       return allBooks.stream()
               .filter(x->x.getBookName().equalsIgnoreCase(bookName)).findFirst();
    }


}
