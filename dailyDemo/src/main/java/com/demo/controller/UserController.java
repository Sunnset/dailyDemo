package com.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.pojo.Result;
import com.demo.service.UserService;
import com.demo.utils.StringManipulation;

/**
 * 用户controller
 * @author wzb
 *
 */
@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 添加用户，注册用户
	 * @param account 账户
	 * @param password 密码
	 * @param nikename 昵称
	 * @return
	 */
	@RequestMapping(value="addUser",method=RequestMethod.POST)
	public @ResponseBody Result register(String account, String password, String nikename){
		if(StringUtils.isEmpty(nikename)||StringUtils.isEmpty(password)||StringUtils.isEmpty(account)){
			return Result.error("信息填写不全");
		}
		Result ret=userService.addUser(account,password,nikename);
		return ret;
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public @ResponseBody Result login(String account,String password){
		Subject subject=SecurityUtils.getSubject();
		//加密密码
		password=StringManipulation.passwordWithMD5ToBase64(password, account);
		UsernamePasswordToken token=new UsernamePasswordToken(account, password);
		try {
			subject.login(token);
			return Result.ok("");
		} catch (AuthenticationException e) {
			//账号密码认证异常
			e.printStackTrace();
			return Result.error("账号或密码输入错误");
		}
		
	}
}
