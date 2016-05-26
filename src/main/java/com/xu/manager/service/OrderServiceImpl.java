package com.xu.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xu.manager.bean.Car;
import com.xu.manager.bean.DateFormat;
import com.xu.manager.bean.Order;
import com.xu.manager.bean.PageBean;
import com.xu.manager.dao.CarDao;
import com.xu.manager.dao.OrderDao;

@Service("orderService")
@Scope("prototype")
@Transactional


public class OrderServiceImpl implements OrderService{
   @Autowired OrderDao orderDao;
   @Autowired CarDao carDao;
	
	public int insert(Order order) {
		orderDao.insert(order);
		carDao.updateStatus(order.getId());
		
		return 0;
		
	}
	
	public List<Order> queryShopping(Order query, PageBean page) {
		List<Order> list = orderDao.queryShopping(query);
		return list;
	}
	
	public List<Order> listOrder(Order query, PageBean page) {
		List<Order> list = orderDao.listOrder(query);
		return list;
	}
	
	public void updateStatus(String id) {
		String Date = DateFormat.getCurrentDateTimeStr();
		orderDao.updateStatus(id,Date);
		
	}
	
	public void updateStatus1(String id) {
		orderDao.updateStatus1(id);
		
	}
	
	public void delete(String id) {
		orderDao.delete(id);
		
	}
	
	public void updateStatusCar(String id) {
		orderDao.updateStatusCar(id);
		
	}
	
	public List<Order> dealOrdered(Order query, PageBean page) {
		List<Order> list = orderDao.dealOrdered(query);
		return list;
	}
	
	public void deleteCar(String id) {
	    orderDao.deleteCar(id);
		
	}
	

}
