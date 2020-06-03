import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;


import com.Ka1.bean.Resfood;
import com.Ka1.bean.Resorder;
import com.Ka1.bean.Resorderitem;
import com.Ka1.bean.Resuser;
import com.Ka1.config.AppConfig;
import com.Ka1.dao.Impl.ResorderitemDaoImpl;
import com.Ka1.dao.ResfoodDao;
import com.Ka1.dao.ResorderDao;
import com.Ka1.dao.ResorderitemDao;
import com.Ka1.dao.ResuserDao;
import com.Ka1.util.Encrypt;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import junit.framework.TestCase;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class AppTest extends TestCase {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private ResfoodDao resfoodDao;

	@Autowired
	private ResuserDao resuserDao;

	@Autowired
	private ResorderDao resorderDao;

	@Autowired
	private ResorderitemDao resorderitemDao;

	@Test
	public void testDataSource() {
		assertNotNull( dataSource);
	}
	@Test
	public void testResfoodDao() {
		List<Resfood> list = resfoodDao.findAllFood();
		assertEquals(list.size(),12);
	}

	@Test
	public void testResuserDao(){
		Resuser resuser = new Resuser();
		resuser.setUsername("a");
		resuser.setPwd(Encrypt.md5("a"));
		Resuser newResuser = resuserDao.login(resuser);
		if(newResuser==null){
			System.out.println("未找到该用户或密码错误");
		}else {
			System.out.println("登录成功");
			System.out.println(newResuser);
		}
	}

	@Test
	public void testResorderDao(){
		Resorder resorder = new Resorder();
		resorder.setUserid(2);
		resorder.setAddress("guangzhou");
		resorder.setTel("123");
		resorder.setOrdertime(new Date(1000));
		resorder.setDeliverytime(new Date(1000));
		resorder.setPs("PS");
		resorder.setStatus(1);

		Resorder newResorder = resorderDao.insertResorder(resorder);
		if(newResorder==null){
			System.out.println("插入失败");
		}else {
			System.out.println(newResorder);
		}
	}

	@Test
	public void testResorderitemDao() {
		Resorderitem ri = new Resorderitem();
		ri.setDealprice(20.0);
		ri.setFid(1);
		ri.setNum(1);
		ri.setRoid(1);      //    注意，一定要先操作  testResorderDao  生成一个订单号   后，再执行这个测试
		resorderitemDao.insertResorderitem(ri);
	}

}
