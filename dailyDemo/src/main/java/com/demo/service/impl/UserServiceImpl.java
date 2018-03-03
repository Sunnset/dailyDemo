package com.demo.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.demo.dao.UserMapper;
import com.demo.pojo.Result;
import com.demo.service.UserService;
import com.demo.utils.StringManipulation;

/**
 * 用户service
 * @author wzb
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 添加用户
	 */
	@Override
	public Result addUser(String account, String password, String nikename) {
		// 对输入密码加密成密文
		password = StringManipulation.passwordWithMD5ToBase64(password,
				nikename);
		try {
			userMapper.addUser(account, password, nikename, new Date());
			return Result.ok("添加成功");
		} catch (DuplicateKeyException e) {
			return Result.error("该手机号已经注册");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("添加失败");
		}
	}
	/**
	 * 根据账户查询用户
	 */
	@Override
	public Map<String,String> getUserByAccount(String account) {
		Map<String,String> user=userMapper.getUserByAccount(account);
		return user;
	}
	/**
	 * 根据账户查询用户的角色
	 */
	@Override
	public Set<String> getRolesByAccount(String account) {
		Set<String> roles=userMapper.getRolesByAccount(account);
		return roles;
	}

}
