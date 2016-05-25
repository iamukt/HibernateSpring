package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import one_to_one_pojos.Account;
import one_to_one_pojos.Employee;
import utils.HibernateUtils;

public class EmpDaoImpl implements EmpDao {

	@Override
	public Employee addEmp(Employee e) throws Exception {
		// get session from SF
		Session sess = HibernateUtils.getFactory().getCurrentSession();
		// begin tx
		Transaction tx = sess.beginTransaction();
		try {
			sess.persist(e);
			tx.commit();
		} catch (HibernateException e1) {
			if (tx != null)
				tx.rollback();
			throw e1;
		}
		return e;
	}

	@Override
	public Account getDetails(String email) throws Exception {
		// as below is join fetch --works with single select
		String jpql = "select a from Account a  join fetch a.employee e where e.email = :em";
		// below jpql work but with 2 select queries
		// String jpql =
		// "select a from Account a  where a.employee.email = :em";
		// get session from SF
		Session sess = HibernateUtils.getFactory().getCurrentSession();
		// begin tx
		Transaction tx = sess.beginTransaction();
		Account a = null;
		Employee e = null;
		try {
			a = (Account) sess.createQuery(jpql).setParameter("em", email)
					.uniqueResult();
			/*
			 * if (e != null) a = e.getAccount();
			 */tx.commit();
		} catch (HibernateException e1) {
			if (tx != null)
				tx.rollback();
			throw e1;
		}
		System.out.println(a);
		return a;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getEmailsByAccountType(String acctType) {
		String jpql = "select a.employee.email from Account a where a.type = :ty";

		Session sess = HibernateUtils.getFactory().getCurrentSession();
		// begin tx
		Transaction tx = sess.beginTransaction();
		List<String> emails = null;
		try {
			emails = sess.createQuery(jpql).setParameter("ty", acctType).list();
			tx.commit();
		} catch (HibernateException e1) {
			if (tx != null)
				tx.rollback();
			throw e1;
		}
		System.out.println(emails);
		return emails;

	}

/*	@Override
	public Employee getEmpDetails(String email) throws Exception {
		// 2 queries
		String jpql = "select e from Employee e join fetch e.account where e.email = :em";

		Session sess = HibernateUtils.getFactory().getCurrentSession();
		// begin tx
		Transaction tx = sess.beginTransaction();

		Employee e = null;
		try {
			e = (Employee) sess.createQuery(jpql).setParameter("em", email)
					.uniqueResult();
			tx.commit();
		} catch (HibernateException e1) {
			if (tx != null)
				tx.rollback();
			throw e1;
		}

		return e;

	}
*/
	@Override
	public Employee getEmpDetails(String email) throws Exception {
		// 2 queries
		String jpql = "select e from Employee e join fetch e.account where e.email = :em";

		Session sess = HibernateUtils.getFactory().getCurrentSession();
		// begin tx
		Transaction tx = sess.beginTransaction();

		Employee e = null;
		try {
			e = (Employee) sess.createQuery(jpql).setParameter("em", email)
					.uniqueResult();
			tx.commit();
		} catch (HibernateException e1) {
			if (tx != null)
				tx.rollback();
			throw e1;
		}

		return e;

	}

	@Override
	public Employee deleteEmployee(String email) throws Exception {

		// works but produces 3 select + 2 delete queries 
		String jpql = "select e from Employee e where e.email = :em";

		Session sess = HibernateUtils.getFactory().getCurrentSession();
		// begin tx
		Transaction tx = sess.beginTransaction();
		Employee e=null;
		
		try {
			e=(Employee)sess.createQuery(jpql).setParameter("em", email)
					.uniqueResult();
			if (e != null)
				sess.delete(e);
			tx.commit();
		} catch (HibernateException e1) {
			if (tx != null)
				tx.rollback();
			throw e1;
		}

		return e;

	}

}
