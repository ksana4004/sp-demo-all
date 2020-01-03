package cn.tedu.sp02.item.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.service.ItemService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Value("${server.port}")
	private int port;
	
	
	@GetMapping("/{orderId}")  //Mapper + method =get
	public  JsonResult<List<Item>>  findItems(@PathVariable String orderId) throws InterruptedException{
		log.info("server.port="+port+", orderId="+orderId);
		if(Math.random()<0.5) {
			System.out.println("随机数为："+Math.random()+"开始延迟");
			try {
				System.out.println("暂停3秒");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/***
		
		**/
		
		List<Item> items = itemService.getItems(orderId);
		
		return JsonResult.ok(items).msg("port="+port);
		//http:localhost:8001/{orderId}
	}
	
	@PostMapping("/decreseNumber")
	public JsonResult decreseNumber(@RequestBody List<Item> items) {
		itemService.decreaseNumbers(items);
		return JsonResult.ok();
		//http://localhost:8001/decreseNumber
		
	}
	
}


