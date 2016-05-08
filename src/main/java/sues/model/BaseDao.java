package sues.model;

import java.sql.Time;
import java.util.List;

import org.hibernate.Session;

public interface BaseDao {
	
	//Search thing
//	public List Query(String sql,Session session) throws Exception;
	
	//Delete thing
	public Boolean execute(String sql, Session session) throws Exception;
	
	//Insert thing
	public Boolean insert(Object object, Session session) throws Exception;

}
