package com.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.tx.Tx;


 
public class EmployeeService {
	
	private Logger logger = Logger.getLogger(EmployeeService.class);
	
	/**
	 * (备份员工的积分数据)
	 * @param departmentId
	 * @return
	 * @throws SQLException
	*/
	@Before(Tx.class)
	public boolean saveReward(String departmentId){
		Boolean bl = true;
		String sql = "insert into bak_sys_reward select * from sys_reward where employee_id in (select id from sys_employee where department_id = "+departmentId+")";
		int save = Db.update(sql);
		if (save > 0) {
        	logger.info("保存积分备份信息成功！");
		} else {
			bl = false;
			logger.info("保存积分备份信息失败！");
		}
		return bl;
	}
	
}
