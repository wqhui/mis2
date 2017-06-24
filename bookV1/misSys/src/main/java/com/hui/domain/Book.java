package com.hui.domain;
/**
 * @author hui
 *
 * */
public class Book {
    private Integer id;

    private String ISBN;

    private String title;
    
    
    private Member loanTo;//借书
    
    //空构造
    public Book() {
    }
    //参数构造
    public Book(Integer id, String ISBN, String title,Member loanTo) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.loanTo = loanTo;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public Member getLoanTo() {
		return loanTo;
	}
	public void setLoanTo(Member loanTo) {
		this.loanTo = loanTo;
	}

    @Override
    public String toString() {
        return "图书{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ",借阅人："+loanTo+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!getId().equals(book.getId())) return false;
        if (!getISBN().equals(book.getISBN())) return false;
        return getTitle().equals(book.getTitle());
    }
    
    
}
