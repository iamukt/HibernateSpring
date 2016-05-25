package tester;

import hib_pojos.Address;
import hib_pojos.Book;
import hib_pojos.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import utils.HibernateUtils;

public class AddPerson {

	public static void main(String[] args) {
		HibernateUtils.getFactory();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Person Name");
			Person p1 = new Person(sc.nextLine());
			System.out.println("Enter Hobbies");
			Scanner sc2=new Scanner(sc.nextLine());
			while(sc2.hasNext())
				p1.getHobbies().add(sc2.next());
			System.out.println("Enter Home address");
			Address a1 = new Address(sc.next(), sc.next(), sc.next());
			System.out.println("Enter Office address");
			Address a2 = new Address(sc.next(), sc.next(), sc.next());
			p1.getAddresses().add(a1);
			p1.getAddresses().add(a2);
			PersonDao dao = new PersonDaoImpl();
			System.out.println("Added person " + dao.addPerson(p1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtils.getFactory().close();// cn pool is destroyed

	}

}
