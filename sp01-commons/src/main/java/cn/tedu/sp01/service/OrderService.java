package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.Order;

public interface OrderService {
	//���ݶ���id��ȡ����
	Order getOrder(String orderId);
	//���涩����   ������������Ʒ���û�������
	void addOrder(Order order);
}
