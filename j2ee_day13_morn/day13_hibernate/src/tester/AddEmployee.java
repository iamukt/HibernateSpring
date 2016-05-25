package tester;

import hib_pojos.Book;

import java.util.Date;
import java.util.Scanner;

import one_to_one_pojos.Account;
import one_to_one_pojos.Employee;
import dao.BookDao;
import dao.BookDaoImpl;
import dao.EmpDao;
import dao.EmpDaoImpl;
import utils.HibernateUtils;

public class AddEmployee {

	public static void main(String[] args) {
		// SF
		HibernateUtils.getFactory();// config n sf -- created
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Employee email fName lastname");
			Employee e1=new Employee(sc.next(), sc.next(), sc.nextLine());
			System.out.println("Enter acct info -- type & opening bal");
			Account a1=new Account(sc.next(), sc.nextDouble());
			e1.setAccount(a1);
			a1.setEmployee(e1);
			EmpDao dao=new EmpDaoImpl();
			System.out.println("emp added "+dao.addEmp(e1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtils.getFactory().close();// cn pool is destroyed
	}
}
