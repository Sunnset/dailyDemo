package com.demo.shiro;

import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.service.UserService;

public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查询权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		String account = arg0.getPrimaryPrincipal().toString();
		Set<String> roles=userService.getRolesByAccount(account);
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.setRoles(roles);
		return info;
	}
	
	/**
	 * 查询用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
		String account = token.getUsername();//账户
		String password = String.valueOf(token.getPassword());//密码
		Map<String, String> user =userService.getUserByAccount(account);
		if(user!=null && password.equals(user.get("password"))){
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(account, password, user.get("nikename"));
			return info;
		}else{
			return null;
		}
	}

}
