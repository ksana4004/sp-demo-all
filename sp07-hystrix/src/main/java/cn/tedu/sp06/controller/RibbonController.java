package cn.tedu.sp06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;

@RestController  //处理请求后，数据响应在responsebody
public class RibbonController {
	
	@Autowired  // RestTemplate
	private RestTemplate rt;
	
	/*远程调用商品服务中  订单id获取商品列表
	 * 
	 * */
	@GetMapping("item-service/{orderId}")  //Mapper + method =get
	@HystrixCommand(fallbackMethod = "getItemsFB")
	public  JsonResult<List<Item>>  getItems(@PathVariable String orderId){
		return rt.getForObject("http://item-service/{1}", JsonResult.class,orderId);
		//http://localhost:3001/item-service/11
	}
	
	/*
	 * */
	@PostMapping("item-service/decreseNumber")  //decreaseNumberFB
	@HystrixCommand(fallbackMethod = "decreaseNumberFB")
	public JsonResult decreseNumber(@RequestBody List<Item> items) {
		
		//http://localhost:8001/decreseNumber
		return rt.postForObject("http://item-service/decreseNumber",items,JsonResult.class);
	}
	//http://localhost:3001/item-service/decreseNumber
	//[{"id":100,"name":"手表","number":10086}]
	
	/**订单业务
	 * 
	 * */
	/*根据用户ID获取用户对象信息
	 * 
	 * */
	@GetMapping("user-service/{userId}")
	@HystrixCommand(fallbackMethod = "getUserFB")
	public JsonResult<User> getUser(@PathVariable Integer userId) {
		return rt.getForObject("http://user-service/{1}", JsonResult.class,userId);
		// http://localhost:8101/7
		
		//http://localhost:3001/user-service/7
	}
	
	@GetMapping("user-service/{userId}/score") 
	@HystrixCommand(fallbackMethod = "addScoreFB")
	public JsonResult addScore(
			@PathVariable Integer userId,Integer score) {
		
		return rt.getForObject("http://user-service/{1}/score?score={2}", JsonResult.class,userId,score);
		
		// http://localhost:8101/7/score?score=100
		//http://localhost:3001/user-service/7/700
		//kv score:700
	}
	
	
	/**订单业务
	 * 
	 * */
	
	@GetMapping("order-service/{orderId}")
	@HystrixCommand(fallbackMethod = "getOrderFB")
	public JsonResult<Order> getOrder(@PathVariable String orderId) {
		
		return rt.getForObject("http://user-service/{1}", JsonResult.class,orderId);
	} //http://localhost:8201/123abc
	//http://localhost:3001/order-service/11
	
	@GetMapping("order-service")
	@HystrixCommand(fallbackMethod = "addOrderFB")
	public JsonResult addOrder() {
		return rt.getForObject("http://order-service", JsonResult.class);
	}
	//http://localhost:8201/
	//http://localhost:3001/order-service/
	//最后加 /
	
/////////////////////////////////////////

//降级方法的参数和返回值，需要和原始方法一致，方法名任意
public JsonResult<List<Item>> getItemsFB(String orderId) {
return JsonResult.err("获取订单商品列表失败");
}
public JsonResult decreaseNumberFB(List<Item> items) {
return JsonResult.err("更新商品库存失败");
}
public JsonResult<User> getUserFB(Integer userId) {
return JsonResult.err("获取用户信息失败");
}
public JsonResult addScoreFB(Integer userId, Integer score) {
return JsonResult.err("增加用户积分失败");
}
public JsonResult<Order> getOrderFB(String orderId) {
return JsonResult.err("获取订单失败");
}
public JsonResult addOrderFB() {
return JsonResult.err("添加订单失败");
}


}
