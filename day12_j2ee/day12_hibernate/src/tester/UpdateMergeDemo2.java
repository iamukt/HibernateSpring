package tester;

import hib_pojos.Book;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.BookDao;
import dao.BookDaoImpl;
import utils.HibernateUtils;

public class UpdateMergeDemo2 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HibernateUtils.getFactory();
			System.out.println("Enter Book Id");
			int id=sc.nextInt();
			//for simple understanding --skipping DAO layer
			//pass existing id -- so that get rets non null
			System.out.println("opening 1st session");
			Session sess = HibernateUtils.getFactory().getCurrentSession();
			// begin tx
			Transaction tx = sess.beginTransaction();
			Book b1=(Book) sess.get(Book.class, id);
			b1.setPrice(b1.getPrice()+100);//modified detached pojo state
			tx.commit();
			System.out.println("closing 1st session");
			//b1 --detached.
			System.out.println("opening 2nd session");
			sess = HibernateUtils.getFactory().getCurrentSession();
			// begin tx
			 tx = sess.beginTransaction();
			Book b2=(Book) sess.get(Book.class, id);//rets persistent pojo
			Book b3=(Book)sess.merge(b1);//detached--->persistent
			System.out.println(b1==b3);
			System.out.println(b1==b2);
			System.out.println(b2==b3);
			tx.commit();
			System.out.println("clsoing 2nd  session");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateUtils.getFactory().close();

	}

}
