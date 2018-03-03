package com.demo.dao;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

/**
 * 用户Mapper
 * @author wzb
 *
 */
public interface UserMapper {
	/**
	 * 添加用户
	 * @param account
	 * @param password
	 * @param nikename
	 * @param date
	 */
	void addUser(@Param("account") String account,@Param("password") String password,@Param("nikename") String nikename,@Param("create_time") Date date);
	/**
	 * 根据账户查询用户信息
	 * @param account
	 * @return
	 */
	Map<String, String> getUserByAccount(String account);
	/**
	 * 根据账户查询对应的角色信息
	 * @param account
	 * @return
	 */
	Set<String> getRolesByAccount(String account);

}
