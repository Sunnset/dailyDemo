package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 * 
 * @author wzb
 * 
 */
@Controller
public class IndexController {
	
	
	@RequestMapping(value="")
	public String getIndexPage(){
		return "login";
	}
	
	
	/**
	 * 跳转到请求的页面
	 * @param page 请求的页面
	 * @return String 请求的页面的网址
	 */
	@RequestMapping(value = "{page}")
	public String getRequestPage(@PathVariable("page") String page) {
		return page;
	}
}
