package com.hui.factory;

import java.time.LocalDateTime;

import com.hui.domain.Book;
import com.hui.domain.Loan;
import com.hui.domain.Member;

public class LoanFactory {
	public static Loan createLoan(Book book, Member member){
        Loan loan=new Loan();
        loan.setBook(book);
        loan.setMember(member);
        loan.setLoanDate(LocalDateTime.now());
        loan.setDateForReturn(LocalDateTime.now().plusDays(31));
        return loan;
    }
}
