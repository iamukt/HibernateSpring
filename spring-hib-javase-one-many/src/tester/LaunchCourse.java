package tester;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.demo.model.*;
import com.app.demo.service.*;

public class LaunchCourse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						"spring-config.xml");) {
			System.out.println("name begin end fees");
			Course c1 = new Course();
			c1.setName(sc.next());
			c1.setBeginDate(sdf.parse(sc.next()));
			c1.setEndDate(sdf.parse(sc.next()));
			c1.setFees(sc.nextDouble());
			CourseRegService service = ctx.getBean(CourseRegService.class);
			System.out.println("Launched Course Details : \n"
					+ service.launchCourse(c1));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
