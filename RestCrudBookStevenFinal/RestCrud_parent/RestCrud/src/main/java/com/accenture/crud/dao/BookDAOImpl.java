package com.accenture.crud.dao;
/**
 * @author DanielGaleano
 */
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.crud.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createBook(Book book) {
		getCurrentSession().save(book);
	}

	@Override
	public Book getBookById(int id) {
		return (Book) getCurrentSession().get(Book.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooks() {
		return getCurrentSession().createQuery("from Book").list();
	}

	@Override
	public void updateBook(Book book) {
		Book bookToUpdate = getBookById(book.getId());
		if (bookToUpdate != null)
			getCurrentSession().merge(book);

	}

	@Override
	public void deleteBook(int id) {
		Book book = getBookById(id);
			if (book != null)
				getCurrentSession().delete(book);
	}

}
