import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;

/**
 * ����dao��
 * @author Administrator
 *1������springTest ģ��
 *2��@ContextConfiguration ����spring �����ļ�
 *3��autowired �Զ��������
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession session;

	@Test
	public void testCRUD(){
		/*��ģʽ����springIOC����*/
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		DepartmentMapper dept = ioc.getBean(DepartmentMapper.class);
//		System.out.println(dept);
		
		
		
		/**
		 * spring ע�ⷽʽ
		 */
		//���벿��
//		departmentMapper.insertSelective(new Department(null, "������"));
//		departmentMapper.insertSelective(new Department(null, "�з���"));
//		System.out.println("���벿�ųɹ�!");

		//����Ա��
//		int num = employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@atguigu.com", 1));
//		System.out.println("����Ա���ɹ���" + num);
		
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5) + i;
			//mapper.insertSelective(new Employee(null, uid, "M", uid + "@atguigu.com", 1));
		}
		System.out.println("�������");
	}

}
