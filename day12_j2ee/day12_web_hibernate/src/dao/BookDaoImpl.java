package dao;

import java.util.Date;
import java.util.List;

import hib_pojos.Book;

import org.hibernate.*;

import utils.HibernateUtils;

public class BookDaoImpl implements BookDao {

	@Override
	public Book addBook(Book b) throws Exception {
		// sess
		Session sess = HibernateUtils.getSf().getCurrentSession();
		// tx
		Transaction tx = sess.beginTransaction();
		try {
			sess.persist(b);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println("detached pojo " + b);
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooksByAuthorNDate(String author, Date pubDate)
			throws Exception {
		String jpql = "select b from Book b where b.author = :au and b.publishDate > :dt";
		// sess
		Session sess = HibernateUtils.getSf().getCurrentSession();
		// tx
		Transaction tx = sess.beginTransaction();
		List<Book> l1 = null;
		try {
			l1 = sess.createQuery(jpql).setParameter("au", author)
					.setParameter("dt", pubDate).list();//l1 -- list of PERSISTENT pojos
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;//l1 -- list of DETAched pojos
	}

}
