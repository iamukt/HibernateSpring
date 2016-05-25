package tester;

import hib_pojos.Book;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImpl;
import utils.HibernateUtils;

public class UpdateBooks {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// SF
		HibernateUtils.getFactory();// config n sf -- created
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter author date amt");

			BookDao dao = new BookDaoImpl();
			System.out.println("Updated book list "
					+ dao.updateBooks(sc.next(), sdf.parse(sc.next()),
							sc.nextDouble()));

		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtils.getFactory().close();// cn pool is destroyed
	}
}
