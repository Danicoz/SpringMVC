import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", 
		"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {
	
	//创建Web全局变量
	@Autowired
	WebApplicationContext context;
	//虚拟MVC请求，获取到处理结果
	MockMvc mockMvc;
	
	//初始化
	@Before
	public void initMokcMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception{
		//模拟请求并拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1"))
				.andReturn();
		
		MockHttpServletRequest request = result.getRequest();
		PageInfo page = (PageInfo) request.getAttribute("pageInfo");
		
		System.out.println("当前页码：" + page.getPageNum());
		System.out.println("总页码：" + page.getPages());
		System.out.println("总记录数：" + page.getTotal());
		System.out.println("需要连续显示的页码：");
		int[] nums = page.getNavigatepageNums();
		for(int i : nums){
			System.out.println(i + " ");
		}
		
	}
	
}














