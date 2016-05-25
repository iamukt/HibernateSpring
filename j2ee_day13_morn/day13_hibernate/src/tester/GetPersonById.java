package tester;


import java.util.Scanner;


import dao.PersonDao;
import dao.PersonDaoImpl;
import utils.HibernateUtils;

public class GetPersonById {

	public static void main(String[] args) {
		HibernateUtils.getFactory();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Person ID");
			PersonDao dao = new PersonDaoImpl();
			System.out.println("Details  " +dao.getPersonById(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtils.getFactory().close();// cn pool is destroyed

	}

}
