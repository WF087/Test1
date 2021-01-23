package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.OrderItem;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import dao.OrderItemDao;




public class OrderItemDaoImpl extends HibernateDaoSupport implements  OrderItemDao{


	public void deleteBean(OrderItem bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(OrderItem bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public OrderItem selectBean(String where) {
		List<OrderItem> list = this.getHibernateTemplate().find("from OrderItem " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from OrderItem "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<OrderItem> selectBeanList(final int start,final int limit,final String where) {
		return (List<OrderItem>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<OrderItem> list = session.createQuery("from OrderItem "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(OrderItem bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}
