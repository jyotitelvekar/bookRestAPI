package com.Example.book.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Example.book.entity.Book;
import com.Example.book.service.BookService;
import com.Example.bookecexception.BookNotFoundException;
import com.Example.bookecexception.BookRecordAlreadyExistsExcep;

//control +0 for seeing how many method we have in controller

@RestController
public class BookController {
	@Autowired
	private BookService service;

	@PostMapping(value = "/saveBook")
	public ResponseEntity<Boolean> saveBookRecord(@Valid @RequestBody Book book) {
		boolean bookAdded = service.saveBookRecord(book);
		if (bookAdded)
			return new ResponseEntity<Boolean>(bookAdded, HttpStatus.OK);
		else
			throw new BookRecordAlreadyExistsExcep("Book Record already present for this bookId " + book.getBookId());
	}

	@GetMapping(value = "/listOfBook")
	public ResponseEntity<List<Book>> getAllBookRecords() {
		List<Book> listOfBook = service.getAllBookRecords();
		if (listOfBook.isEmpty())
			throw new BookNotFoundException("bookList not found");
		else
			return new ResponseEntity<List<Book>>(listOfBook, HttpStatus.OK);
	}

	@GetMapping(value = "/getBookById")
	public ResponseEntity<Book> getBookById(@RequestParam int bookId) {
		Book book = service.getBookById(bookId);
		if (book != null)
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		else
			throw new BookNotFoundException("book not found for bookId" + bookId);
	}

	@PutMapping(value = "/updateBook")
	public ResponseEntity<Boolean> updateBookRecord(@Valid @RequestBody Book book) {
		boolean bookUpdated = service.updateBookRecord(book);
		if (bookUpdated)
			return new ResponseEntity<Boolean>(bookUpdated, HttpStatus.OK);
		else
			throw new BookNotFoundException("book not found for update");
	}

	@DeleteMapping(value = "/deleteBookRecord")
	public ResponseEntity<Boolean> deleteBookRecord(@RequestParam int bookId) {
		boolean bookDeleted = service.deleteBookRecord(bookId);
		if (bookDeleted)
			return new ResponseEntity<Boolean>(bookDeleted, HttpStatus.OK);
		else
			throw new BookNotFoundException("book not found for delete");
	}

	@GetMapping(value = "/maxPriceBook")
	public ResponseEntity<Book> maxPriceBook() {
		Book book = service.getMaxPriceOfBookRecord();
		if (book != null)
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		else
			throw new BookNotFoundException("book not found" + book.getBookId());

	}

	@GetMapping(value = "/getBookCount")
	public ResponseEntity<Long> getCountOfAllBooks() {
		long count = service.getCountOfAllBookRecords();
		if (count > 0)
			return new ResponseEntity<Long>(count, HttpStatus.OK);
		else
			throw new BookNotFoundException("book records not found");
	}

	@GetMapping(value = "/sortBy")
	public ResponseEntity<List<Book>> sortBook(@RequestParam String sortBy) {
		List<Book> list = service.sortBookRecords(sortBy);
		if (list.isEmpty())
			throw new BookNotFoundException(sortBy);
		else
			return new ResponseEntity<List<Book>>(list, HttpStatus.OK);

	}

}
