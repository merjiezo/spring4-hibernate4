package sues.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javassist.expr.Instanceof;

@Repository
public class ContentDao extends BaseDaoimpl {
	
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * 增加、删除、修改需要事务tx
	 */
	public boolean addContent(Content content) throws Exception {
		Session session = sessionFactory.openSession();
		return this.insert(content, session);
	}
	
	public boolean updateContent(Content content) throws Exception {
		Session session = sessionFactory.openSession();
		String sql = "UPDATE content SET contents='"+content.getContents()+"' WHERE row='"+content.getRow()+"'";
		return this.execute(sql, session);
	}
	
	//if there is a session open, must close it when it's done!
	public List<Content> queryOneRecordById(String row) {
		Session sess = sessionFactory.openSession();
		String sql = "SELECT * FROM content WHERE row ='"+row+"'";
		SQLQuery query = sess.createSQLQuery(sql);
		query.addEntity(Content.class);
		List<Content> result = query.list();
		sess.close();
		return result;
	}
	
}
