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

public class GetEmailsByAcctType {

	public static void main(String[] args) {
		// SF
		HibernateUtils.getFactory();// config n sf -- created
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Account type");
			String type = sc.next();
			EmpDao dao = new EmpDaoImpl();
			System.out.println("Acct type " + type + " Emails "
					+ dao.getEmailsByAccountType(type));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtils.getFactory().close();// cn pool is destroyed
	}
}
