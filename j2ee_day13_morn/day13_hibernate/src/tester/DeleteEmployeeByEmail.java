package tester;




import java.util.Scanner;
import dao.EmpDao;
import dao.EmpDaoImpl;
import utils.HibernateUtils;

public class DeleteEmployeeByEmail {

	public static void main(String[] args) {
		// SF
		HibernateUtils.getFactory();// config n sf -- created
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Employee email to delete");
			String em = sc.next();
			EmpDao dao = new EmpDaoImpl();
			System.out.println("Deleted Emp info " +dao.deleteEmployee(em));
		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtils.getFactory().close();// cn pool is destroyed
	}
}
