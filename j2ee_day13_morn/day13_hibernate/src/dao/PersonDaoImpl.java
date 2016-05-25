package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;
import hib_pojos.Person;

public class PersonDaoImpl implements PersonDao {

	@Override
	public Person addPerson(Person p) throws Exception {
		// get session from SF
		Session hibSession = HibernateUtils.getFactory().getCurrentSession();
		// begin tx
		Transaction tx = hibSession.beginTransaction();

		try {
			hibSession.persist(p);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return p;

	}

	@Override
	public Person deletePerson(Person p) throws Exception {
		// get session from SF
		Session hibSession = HibernateUtils.getFactory().getCurrentSession();
		// begin tx
		Transaction tx = hibSession.beginTransaction();

		try {
			hibSession.delete(p);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return p;

	}

	@Override
	public Person getPersonById(Integer id) throws Exception {
		// get session from SF
		Session hibSession = HibernateUtils.getFactory().getCurrentSession();
		// begin tx
		Transaction tx = hibSession.beginTransaction();
		Person p = null;

		try {
			p=(Person)hibSession.get(Person.class, id);
		    System.out.println(p.getAddresses().size());
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return p;

	}

}
