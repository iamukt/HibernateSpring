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

public class GetAccountByEmpEmail {

	public static void main(String[] args) {
		// SF
		HibernateUtils.getFactory();// config n sf -- created
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Employee email");
			String em=sc.next();
			EmpDao dao = new EmpDaoImpl();
			System.out.println("Acct for "+em+" "+dao.getDetails(em));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtils.getFactory().close();// cn pool is destroyed
	}
}
