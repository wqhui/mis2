package com.hui.domain;

import java.time.LocalDateTime;

public class Loan {
	  private Integer id;
	    private LocalDateTime loanDate;//借书时间
	    private LocalDateTime dateForReturn;//到期时间
	    private LocalDateTime returnDate;//还书时间
	    private Book book;
	    private Member member;

	    public Loan() {
	    }

	    public Loan(Integer id, LocalDateTime loanDate, LocalDateTime dateForReturn, LocalDateTime returnDate, Book book, Member member) {
	        this.id = id;
	        this.loanDate = loanDate;
	        this.dateForReturn = dateForReturn;
	        this.returnDate = returnDate;
	        this.book = book;
	        this.member = member;
	    }

	    /**
	     * 判断图书是否归还
	     * @return
	     */
	    public boolean hasNotBeenReturned(){
	        return returnDate==null;
	    }

	    /**
	     * 归还图书
	     */
	    public void markAsReturned(){
	        returnDate=LocalDateTime.now();
	    }
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public LocalDateTime getLoanDate() {
	        return loanDate;
	    }

	    public void setLoanDate(LocalDateTime loanDate) {
	        this.loanDate = loanDate;
	    }

	    public LocalDateTime getDateForReturn() {
	        return dateForReturn;
	    }

	    public void setDateForReturn(LocalDateTime dateForReturn) {
	        this.dateForReturn = dateForReturn;
	    }

	    public LocalDateTime getReturnDate() {
	        return returnDate;
	    }

	    public void setReturnDate(LocalDateTime returnDate) {
	        this.returnDate = returnDate;
	    }

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
	    
	    @Override
	    public String toString(){
			return member.getName()+ '\'' +
				   book.getTitle()+ '\'' +
				   book.getISBN()+ '\'' +
				   loanDate+ '\'' +
				   dateForReturn+ '\'' +
				   returnDate+ '\'' +"";
	    	
	    }
}
