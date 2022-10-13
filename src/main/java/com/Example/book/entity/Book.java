package com.Example.book.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
public class Book {
	@Id
	private int bookId;
	@NotNull(message = "bookName Required")
	private String bookName;
	@NotNull(message = "bookAutherName required")
	private String bookAuthorName;
	@NotNull(message = "bookPublisherCompany required")
	private String bookPublisherCompany;
	@Min(1)
	private int bookPrice;
	@Min(1)
	private int bookPageNo;
	

	public Book() {
		// TODO Auto-generated constructor stub
	}

	

	public Book(int bookId, @NotNull(message = "bookName Required") String bookName,
			@NotNull(message = "bookAutherName required") String bookAuthorName,
			@NotNull(message = "bookPublisherCompany required") String bookPublisherCompany, @Min(1) int bookPrice,
			@Min(1) int bookPageNo) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthorName = bookAuthorName;
		this.bookPublisherCompany = bookPublisherCompany;
		this.bookPrice = bookPrice;
		this.bookPageNo = bookPageNo;
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getBookAuthorName() {
		return bookAuthorName;
	}



	public void setBookAuthorName(String bookAuthorName) {
		this.bookAuthorName = bookAuthorName;
	}



	public String getBookPublisherCompany() {
		return bookPublisherCompany;
	}



	public void setBookPublisherCompany(String bookPublisherCompany) {
		this.bookPublisherCompany = bookPublisherCompany;
	}



	public int getBookPrice() {
		return bookPrice;
	}



	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}



	public int getBookPageNo() {
		return bookPageNo;
	}



	public void setBookPageNo(int bookPageNo) {
		this.bookPageNo = bookPageNo;
	}



	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthorName=" + bookAuthorName
				+ ", bookPublisherCompany=" + bookPublisherCompany + ", bookPrice=" + bookPrice + ", bookPageNo="
				+ bookPageNo + "]";
	}



	
}
