package com.hui.test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import com.hui.domain.Book;
import com.hui.domain.Loan;
import com.hui.domain.Member;

public class bookTest {
	private static Member member1=null;
    private static Member member2=null;
    private static Book book1=null;
    private static Book book2=null;
    private static Book book3=null;
    private static Book book4=null;
    private static Book book5=null;
    private static Book book6=null;
    private static Book book7=null;
	
	/**
	 * 添加数据
	 **/
	public static void setBookList(){
		//添加人员
        member1=new Member(123456,"zhangsan",new ArrayList<Loan>());
        member2=new Member(654321,"lisi",new ArrayList<Loan>());

        //添加书籍
        book1=new Book(1,"0001","JAVA核心卷1)",member1);
        book2=new Book(2,"0002","三体1",null);
        book3=new Book(3,"0003","三体2",null);
        book4=new Book(4,"0004","三体3",member2);
        book5=new Book(5,"0005","JAVA核心卷2",member1);
        book6=new Book(6,"0006","黑客与画家",null);
        book7=new Book(7,"0007","黑客与画家111",null);
        
        
        //当前时间
        LocalDateTime now=LocalDateTime.now();
        //已经还书
        Loan loan1=new Loan(1, now.minusDays(30),now.minusDays(0),now.minusDays(25),book6,member1);      
        Loan loan2=new Loan(2, now.minusDays(42),now.minusDays(11),now.minusDays(33),book2,member2);
        Loan loan3=new Loan(3, now.minusDays(30),now.minusDays(0),now.minusDays(25),book3,member2);

        //未还
        Loan loan4=new Loan(4, now.minusDays(10),now.plusDays(21),null,book1,member1);       
        Loan loan5=new Loan(5, now.minusDays(20),now.plusDays(11),null,book5,member1);
        Loan loan6=new Loan(5, now.minusDays(20),now.plusDays(11),null,book4,member2);

        
        //添加借书关联
        member1.getLoans().add(loan1);
        member1.getLoans().add(loan4);
        member1.getLoans().add(loan5);
        
        member2.getLoans().add(loan2);
        member2.getLoans().add(loan3);
        member2.getLoans().add(loan6);
        

	}
	
	
	public static void myLoanBook(Member m,Book b){
		
		System.out.println(m.getName()+"借书："+b.getTitle());
		System.out.println("是否能借："+m.canLoan(b));//最多借两本，不能借
		System.out.println("----------------");
		m.getLoans().stream().filter(loan ->loan.getReturnDate()==null)
		.forEach(loan -> {	
          System.out.println("之前借阅："+loan.toString());
        });//之前借阅
		if(m.canLoan(b)){
			m.loan(b);
		}
		System.out.println("----------------");
		m.getLoans().stream().filter(loan ->loan.getReturnDate()==null)
			.forEach(loan -> {	
	          System.out.println("之后借阅："+loan.toString());
	        });//之后借阅
		System.out.println("----------------");
		m.getLoans().stream().forEach(loan -> {	
          System.out.println("借书记录："+loan.toString());
        });//借书历史
		System.out.println("----------------------------------------");
	}
	
	
	@Test
	public void loanBook(){
		setBookList();
		
		//张三借书
		myLoanBook(member1,book7);	
		
		//李四借书
		myLoanBook(member2,book7);
		
		
	}
	
	
}
