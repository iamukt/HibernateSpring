package tester;

import hib_pojos.Book;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.BookDao;
import dao.BookDaoImpl;
import utils.HibernateUtils;

public class UpdateMergeDemo0 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HibernateUtils.getFactory();
			System.out.println("Enter Book Id");
			int id=sc.nextInt();
			//for simple understanding --skipping DAO layer
			//pass non-existing book id -- to see StaleStateExc
			//pass existing book id --update query fired , detached --->persistent
			System.out.println("opening 1st session");
			Book b1=new Book();//transient
			b1.setBookId(id);
			Session sess = HibernateUtils.getFactory().getCurrentSession();
			// begin tx
			Transaction tx = sess.beginTransaction();
			sess.update(b1);
			tx.commit();
			System.out.println("closing 1st session");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateUtils.getFactory().close();

	}

}
