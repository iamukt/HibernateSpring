package tester;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.demo.model.*;
import com.app.demo.service.*;

public class RegisterStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						"spring-config.xml");) {
			System.out.println("Enter course name");
			String nm = sc.next();
			System.out.println("Enter student dtls : nm email addr");
			Student s1 = new Student();
			s1.setName(sc.next());
			s1.setEmail(sc.next());
			s1.setAddr(sc.next());
			CourseRegService service = ctx.getBean(CourseRegService.class);
			// when service method rets null --> student couldn't be added
			// because of dup email id. --so give proper err mesg
			Student regStudent = service.registerStudent(nm, s1);
			if (regStudent == null)
				System.out.println("Student reg error : dup email id");
			else
				System.out.println("Reged student successfully  " + regStudent);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
