package im.lich.framework.core.base.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * base dao
 * 
 * @author ethan
 */
public class BaseDAO<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {

	@Resource
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
