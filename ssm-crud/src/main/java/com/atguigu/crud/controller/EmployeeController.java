package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ����Ա��CRUD ����
 * 
 * @author Danicoz
 *
 *         1�������࣬ jsp ת�������ﴦ��
 */
@Controller
public class EmployeeController {
	// ����Service ����ҵ���߼�
	@Autowired
	EmployeeService employeeService;
	
	/*
	 * ����jackson ���� �ѷ��صĶ�������json ����
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
		PageHelper.startPage(pn, 5);// ������ѯ���ݷ������Ƿ�ҳ��ѯ
		List<Employee> emps = employeeService.getAll();

		// ��װ����ϸ�ķ�ҳ��Ϣ������Ա����Ϣ�� 5 ��ʾ������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
		return Msg.sucess().add("pageInfo", page);
	}
	
	/**
	 * @RequestMapping("/emps")
	 * jsp ʵ�ֵĽ�����ʾ
	 */
	// ��ת������URI
	public String getEmps(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		System.out.println("��ת�ɹ���");

		// ����pageHelper ���з�ҳ��ѯ
		// ����ҳ���ÿҳ������
		PageHelper.startPage(pn, 5);// ������ѯ���ݷ������Ƿ�ҳ��ѯ
		List<Employee> emps = employeeService.getAll();

		// ��װ����ϸ�ķ�ҳ��Ϣ������Ա����Ϣ�� 5 ��ʾ������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
		
		//����Ϣ����Model�У���������jsp ȡ��
		model.addAttribute("pageInfo", page);
		return "list";// ������ҳ��������������ת����Ӧ��jsp��
	}

}
