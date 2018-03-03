package com.demo.service;

import java.util.Map;
import java.util.Set;

import com.demo.pojo.Result;

public interface UserService {
	//添加用户
	Result addUser(String account, String password, String nikename);
	//根据账户查询用户
	Map<String, String> getUserByAccount(String account);
	//根据账户查询对应的权限
	Set<String> getRolesByAccount(String account);

}
