package dao;

import rev_eng.CustomerPOJO;
import utils.HibernateUtils;

import org.hibernate.*;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public CustomerPOJO validateCustomer(String email, String pass1)
			throws Exception {
		CustomerPOJO cust = null;
		String hql = "from CustomerPOJO c where c.email =:em and c.password = :pass";
		// sess
		Session hs = HibernateUtils.getFactory().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			cust = (CustomerPOJO) hs.createQuery(hql).setParameter("em", email)
					.setParameter("pass", pass1).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println("dao reted " + cust);
		return cust;
	}

}
