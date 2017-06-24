package com.hui.domain;

import java.util.ArrayList;
import java.util.List;

import com.hui.domain.spec.HasReachMaxSpecification;
import com.hui.domain.spec.LoanOnlyOneSpecification;
import com.hui.factory.LoanFactory;

/**
 * @author hui
 *
 * */
public class Member {
	 private Integer id;
	 private String name;
	 private List<Loan> loans=new ArrayList<Loan>();
	 
	 public Member(){};
	 public Member(Integer id, String name,ArrayList<Loan> loans){
		 	this.id=id;
		 	this.name=name;
		 	this.loans=loans;
	 }
	 
	 


    /**
     * 首先判断是否可借，如果可借则生成借书记录
     * @param book
     * @return
     */
    public Loan loan(Book book){
        Loan loan=null;
        if(canLoan(book)){
            loan=LoanFactory.createLoan(book,this);
            book.setLoanTo(this);
            getLoans().add(loan);
        }
        return loan;
    }

    
    /**
     * 通过判断book的loanTo属性判断该书是否可借
     * @param 
     * @return 
     */
    public boolean canLoan(Book book){
        HasReachMaxSpecification hasReachMaxSpecification=new HasReachMaxSpecification();
        LoanOnlyOneSpecification loanOnlyOneSpecification=new LoanOnlyOneSpecification(book);
        return book.getLoanTo()==null && hasReachMaxSpecification.isSatisfiedBy(this)&& loanOnlyOneSpecification.isSatisfiedBy(this);
    }

    
    /**
     * 查询当前所借书籍
     * @param 
     * @return
     */
    public Loan findCurrentLoanFor(Book book){
		return null;

    }

    /**
     * 还书
     * @param book
     */
    public void returnBook(Book book){
        Loan loan=this.findCurrentLoanFor(book);
        if(loan!=null){
            loan.markAsReturned();
            book.setLoanTo(null);
        }
    }	 
	 
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
	 
}
