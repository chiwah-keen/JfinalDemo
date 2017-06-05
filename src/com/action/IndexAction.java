/**
 * IndexAction.java
 * com.action
 * author      date      	
 * ──────────────────────────────────
 * jianzhihua    2017年6月5日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止使用
 * 
*/
package com.action;

import com.jfinal.core.Controller;

 
public class IndexAction extends Controller{
	
	public void index(){
		renderText("success!");
	}
	
}
