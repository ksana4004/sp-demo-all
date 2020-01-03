package cn.tedu.sp03.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*根据用户ID获取用户对象信息
	 * */
	@GetMapping("/{userId}")
	public JsonResult<User> getUser(@PathVariable Integer userId) {
		log.info("get user, userId="+userId);
		User u = userService.getUser(userId);
		return JsonResult.ok(u);
		
		// http://localhost:8101/7
	}
	
	/*根据用户ID，给用户增加分数
	 * @param Integer userId  用户ID 同时作为路径
	 * 因为是作为路径 restful 需要加@PathVariable
	 * @param Integer score  用户增加的分数
	 *  名字不一样需要用注解获取指定参数名  @RequestParam("score") core
	 * @return JsonResult  返回请求状态
	 * 
	 * */
	@GetMapping("/{userId}/score") 
	public JsonResult addScore(
			@PathVariable Integer userId,Integer score) {
		userService.addScore(userId, score);
		return JsonResult.ok();
		
		// http://localhost:8101/7/score?score=100
	}
}

