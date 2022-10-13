package com.Example.book.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Example.book.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveBookRecord(Book book) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean bookAdded = false;
		try {
			Book b = session.get(Book.class, book.getBookId());
			if (b == null)
				session.save(book);
			transaction.commit();
			bookAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return bookAdded;
	}

	@Override
	public Book getBookById(int bookId) {
		Session session = sessionFactory.openSession();
		Book book = null;
		try {
			book = session.get(Book.class, bookId);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return book;
	}

	@Override
	public List<Book> getAllBookRecords() {
		Session session = sessionFactory.openSession();
		List<Book> listOfBook = null;
		try {
			Criteria criteria = session.createCriteria(Book.class);
			listOfBook = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return listOfBook;
	}

	@Override
	public boolean updateBookRecord(Book book) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean bookUpdated = false;
		try {
			Book book2 = session.get(Book.class, book.getBookId());
			if (book2 != null)
				session.evict(book2);
			session.update(book);
			transaction.commit();
			bookUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();

		}
		return bookUpdated;
	}

	@Override
	public boolean deleteBookRecord(int bookId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean bookDeleted = false;
		try {
			Book book = session.get(Book.class, bookId);
			if (book != null)
				session.delete(book);
			transaction.commit();
			bookDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return bookDeleted;
	}

	@Override
	public Book getMaxPriceOfBookRecord() {
		Session session = sessionFactory.openSession();
		int max = 0;
		List<Book> list = null;
		Book book = null;
		try {
			Criteria criteria = session.createCriteria(Book.class);
			criteria.setProjection(Projections.max("bookPrice"));
			max = (int) criteria.list().get(0);
			Criteria criteria2 = session.createCriteria(Book.class);
			criteria2.add(Restrictions.eq("bookPrice", max));
			book = (Book) criteria2.list().get(0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return book;

	}

	@Override
	public long getCountOfAllBookRecords() {
		Session session = sessionFactory.openSession();
		long count = 0;
		try {
			Criteria criteria = session.createCriteria(Book.class);
			criteria.setProjection(Projections.rowCount());
			count = (long) criteria.list().get(0);

		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			if(session!=null)
				session.close();
		}
		return count;
	}

	@Override
	public List<Book> sortBookRecords(String sortBy) {
		Session session = sessionFactory.openSession();
		List<Book> list=null;
		try {
			Criteria criteria = session.createCriteria(Book.class);
			criteria.addOrder(Order.asc(sortBy));//addOrder reuired order obj
			list=criteria.list();
			
		} catch (Exception e) {

		e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}

}
