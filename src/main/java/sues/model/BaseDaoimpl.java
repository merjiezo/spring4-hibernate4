package sues.model;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BaseDaoimpl implements BaseDao {

	public Boolean execute(String sql, Session session) throws Exception {
		Boolean result = true;
		session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch(Exception e) {
			result = false;
			session.getTransaction().rollback();
			throw new Exception("Hibernate Transaction failed", e);
		} finally {
			session.close();
		}
		return result;
	}

	public Boolean insert(Object object, Session session) throws Exception {
		Boolean result = true;
		session.beginTransaction();
		try {
			session.save(object);
			session.getTransaction().commit();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			result = false;
			session.getTransaction().rollback();
			throw new Exception("Hibernate Transaction failed", e);
		} finally {
			session.close();
		}
		return result;
	}
	

}
