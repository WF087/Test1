package dao;

import java.util.List;

import model.OrderItem;







public interface OrderItemDao  {
	
	
	
	public void insertBean(OrderItem bean);
	
	public void deleteBean(OrderItem bean);
	
	public void updateBean(OrderItem bean);

	public OrderItem selectBean(String where);
	
	public List<OrderItem> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
