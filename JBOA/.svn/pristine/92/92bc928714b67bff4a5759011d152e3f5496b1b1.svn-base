package cn.jboa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jboa.dao.LeaveDao;
import cn.jboa.entity.Leave;

public class LeaveDaoImpl extends HibernateDaoSupport implements LeaveDao {

	@Override
	public List<Leave> searchLeaves(Leave leave, final int pageIndex, final int pageSize) {
		// TODO Auto-generated method stub
		final String hql = "from Leave l";
		return this.getHibernateTemplate().execute(
				new HibernateCallback<List<Leave>>() {
					public List<Leave> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setFirstResult((pageIndex - 1) * pageSize);
						query.setMaxResults(pageSize);
						return query.list();
					}
				});

	}

	@Override
	public int getLeaveTotalCount(Leave leave) {
		return ((Number) this.getHibernateTemplate()
				.find("select count(id) from Leave l").listIterator()
				.next()).intValue();

	}

	
	
}
