package tester;

import hib_pojos.Account;
import hib_pojos.AccountPK;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

public class CreateAccount {

	public static void main(String[] args) {
		// get SF
		HibernateUtils.getFactory();

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter  Account dtls type name bal");
			Account a1 = new Account(sc.next(), sc.next(), sc.nextDouble());
			System.out.println("Enter acct id n cust id");
			AccountPK key1 = new AccountPK(sc.next(), sc.next());
			a1.setId(key1);
			System.out.println("Enter  2nd Account dtls type name bal");
			Account a2 = new Account(sc.next(), sc.next(), sc.nextDouble());
			System.out.println("Enter 2nd acct id n cust id");
			AccountPK key2 = new AccountPK(sc.next(), sc.next());
			a2.setId(key2);
			// sess
			Session sess = HibernateUtils.getFactory().getCurrentSession();
			// tx
			Transaction tx = sess.beginTransaction();
			try {
				sess.save(a1);
				sess.save(a2);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
