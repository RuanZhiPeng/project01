package cn.yinmei.com.testDemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import com.SpringBootDemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootDemoApplication.class)
public class StoreApplicationTests {
	
	@Test
	public void test() {
		System.err.println("有用？");
	}
	
	
	

}
