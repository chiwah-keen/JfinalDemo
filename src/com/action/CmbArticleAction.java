/**
 * CmbArticleAction.java
 * com.action
 * author      date      	
 * ──────────────────────────────────
 * jianzhihua    2017年6月5日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止使用
 * 
*/
package com.action;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;

 
public class CmbArticleAction extends Controller{
	
	private static Logger logger = Logger.getLogger(CmbArticleAction.class);
	

	
	public void index(){
		renderJson(String.format("{\"href\":\"%s%s\"}", this.getRequest().getLocalAddr(), this.getRequest().getContextPath()));
	}
	
	
	@Before(POST.class)
	public void articleOnline(){
		logger.info("=======================");
	}
}
