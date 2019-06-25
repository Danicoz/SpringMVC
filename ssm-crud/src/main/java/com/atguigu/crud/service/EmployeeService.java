package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;

/**
 * 
 * @author Danicoz
 *
 *1��Ա��ҵ������Dao �򽻵�
 */
@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;//����Dao
	
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<Employee> getAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}

}
