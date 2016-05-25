package tester;

import hib_pojos.Book;

import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImpl;
import utils.HibernateUtils;

public class UpdateDemo {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HibernateUtils.getFactory();
			System.out.println("Enter Book Id");
			BookDao dao = new BookDaoImpl();
			Book ref = dao.getBookById(sc.nextInt());
			if (ref == null)
				System.out.println("Book not found....");
			else {
				System.out.println("Current Book dtls " + ref);// ref - detached
				System.out.println("Enter new qty n price");
				ref.setQuantity(sc.nextInt());
				ref.setPrice(sc.nextDouble()); // modified obj state --heap
				System.out.println("Updated book "
						+ dao.updateBook(ref));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateUtils.getFactory().close();

	}

}
