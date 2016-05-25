package tester;

import hib_pojos.Book;

import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImpl;
import utils.HibernateUtils;

public class DeleteBookByAuthor {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HibernateUtils.getFactory();
			System.out.println("Enter Author");
			BookDao dao = new BookDaoImpl();
			System.out.println("list of deleted books "
					+ dao.deleteBooks(sc.next()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateUtils.getFactory().close();

	}

}
