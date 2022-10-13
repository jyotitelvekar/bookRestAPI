package com.Example.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Example.book.dao.BookDao;
import com.Example.book.entity.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao dao;

	@Override
	public boolean saveBookRecord(Book book) {
		boolean bookAdded = dao.saveBookRecord(book);
		return bookAdded;
	}

	@Override
	public Book getBookById(int bookId) {
		Book book = dao.getBookById(bookId);
		return book;
	}

	@Override
	public List<Book> getAllBookRecords() {
		List<Book> listOfBook = dao.getAllBookRecords();
		return listOfBook;
	}

	@Override
	public boolean updateBookRecord(Book book) {
		boolean bookUpdated = dao.updateBookRecord(book);
		return bookUpdated;
	}

	@Override
	public boolean deleteBookRecord(int bookId) {
		boolean bookDeleted = dao.deleteBookRecord(bookId);
		return bookDeleted;
	}

	@Override
	public Book getMaxPriceOfBookRecord() {
		Book book = dao.getMaxPriceOfBookRecord();
		return book;
	}

	@Override
	public long getCountOfAllBookRecords() {
		long count = dao.getCountOfAllBookRecords();
		return count;
	}

	@Override
	public List<Book> sortBookRecords(String sortBy) {
		List<Book> list = dao.sortBookRecords(sortBy);
		
		return list;
	}

}
