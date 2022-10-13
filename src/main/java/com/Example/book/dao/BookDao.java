package com.Example.book.dao;

import java.util.List;

import com.Example.book.entity.Book;

public interface BookDao {
	public boolean saveBookRecord(Book book);

	public Book getBookById(int bookId);

	public List<Book> getAllBookRecords();

	public boolean updateBookRecord(Book book);

	public boolean deleteBookRecord(int bookId);

	public Book getMaxPriceOfBookRecord();

	public long getCountOfAllBookRecords();
	
	public List<Book>sortBookRecords( String sortBy);

}
