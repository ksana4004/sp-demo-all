package cn.tedu.sp01.service;

import java.util.List;

import cn.tedu.sp01.pojo.Item;

public interface ItemService {
	//根据订单ID获取订单商品信息
	List<Item> getItems(String orderId);
	//根据
	//根据商品列表  减少库存
	void decreaseNumbers(List<Item> list);

}
