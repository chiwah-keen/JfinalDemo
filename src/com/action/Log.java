/**
 * Log.java
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

 
public class Log {
	private static Logger logger = Logger.getLogger(Log.class);  

    public static void main(String[] args) {  

     //  记录 debug 级别的信息   

      logger.debug("This is debug message.");  

      //  记录 info 级别的信息   

      logger.info("This is info message.");  

      //  记录 error 级别的信息   

      logger.error("This is error message.");  

  }  
}
