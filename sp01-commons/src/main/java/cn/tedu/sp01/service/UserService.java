package cn.tedu.sp01.service;

import cn.tedu.sp01.pojo.User;

public interface UserService {
	
	//根据用户id获取用户信息
	User getUser(Integer id);
	
	//给用户增加积分
	void addScore(Integer id, Integer score);
}
