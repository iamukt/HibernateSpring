package utils;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(
				cfg.getProperties()).buildServiceRegistry();
		sf=cfg.buildSessionFactory(reg);
		System.out.println("sf created");
	}
	public static SessionFactory getSf() {
		return sf;
	}
	

}
