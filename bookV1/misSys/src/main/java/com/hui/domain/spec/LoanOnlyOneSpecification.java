package com.hui.domain.spec;

import com.hui.domain.Book;
import com.hui.domain.Member;

public class LoanOnlyOneSpecification implements Specification {
	private Book wantedBook;
	
	public LoanOnlyOneSpecification(Book wantedBook){
		this.wantedBook=wantedBook;
	};
	
    @Override
    public boolean isSatisfiedBy(Member member) {
        return member.getLoans().stream()//获取一个List中，满足->后条件的个数
                .filter(loan -> loan.hasNotBeenReturned() && wantedBook.getISBN().equals(loan.getBook().getISBN()))
                .count()==0;
    }
	public Book getWantedBook() {
		return wantedBook;
	}
	public void setWantedBook(Book wantedBook) {
		this.wantedBook = wantedBook;
	}
    
}
