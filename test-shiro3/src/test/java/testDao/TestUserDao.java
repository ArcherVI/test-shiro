package testDao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wh51net.test.dao.UserDao;
import com.wh51net.test.entity.User;

public class TestUserDao {
	
	private ApplicationContext ctx;
	
	@Resource
	private UserDao userDao;
	
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void test1() {
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		System.out.println("dataSource:"+dataSource);
	}
	
	@Test
	public void test2() {
		User user = userDao.queryByUsername("root1");
		System.out.println("user:"+user);
	}
}
