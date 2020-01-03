package cn.tedu.sp01.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	//订单id
	private String id;
	//订单用户
	private User user;
	//订单商品列表
	private List<Item> items;

}
