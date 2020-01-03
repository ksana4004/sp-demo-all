package cn.tedu.sp02.item.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.service.ItemService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service			//springCloud注解  ？？？
public class ItemServiceImpl implements ItemService{
	
	//LoggerFactory

	@Override
	public List<Item> getItems(String orderId) {
		List<Item> items =new ArrayList<>();
		items.add(new Item(100,"手表",10086));
		items.add(new Item(101,"手表01",100801));
		items.add(new Item(102,"play",802));
		items.add(new Item(103,"run",803));
		/* 
		[{"id":102, "name":"play", "number":802},{"id":103, "name":"run", "number":803}]
	private Integer id;  //商品ID
	private String name;  //商品名字
	private Integer number;  //商品编号
		 * */
		// TODO Auto-generated method stub
		
		
		return items;
	}

	@Override
	public void decreaseNumbers(List<Item> list) {
		for (Item item : list) {
			log.info("减少库存-"+item);
		}
		
		
	}

}
