package tester;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.demo.model.*;
import com.app.demo.service.*;

public class CancelCourse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						"spring-config.xml");) {
			System.out.println("Enter course name to cancel");
			String nm = sc.next();
			CourseRegService service = ctx.getBean(CourseRegService.class);
			Course regCourse = service.cancelCourse(nm);
			if (regCourse != null)
				System.out.println("Sending mail to students  :"
						+ regCourse.getStudents());
			else
				System.out.println("Course name invalid");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
