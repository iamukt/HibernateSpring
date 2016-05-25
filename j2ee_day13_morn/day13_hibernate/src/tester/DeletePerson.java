package tester;

import hib_pojos.Address;
import hib_pojos.Book;
import hib_pojos.Person;

import java.util.Date;
import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import utils.HibernateUtils;

public class DeletePerson {

	public static void main(String[] args) {
		HibernateUtils.getFactory();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Person ID");
			Person p1 = new Person();
			p1.setId(sc.nextInt());
			PersonDao dao = new PersonDaoImpl();
			System.out.println("deleted person " + dao.deletePerson(p1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtils.getFactory().close();// cn pool is destroyed

	}

}
