import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xu.manager.dao.DealDao;
import com.xu.manager.dao.PdByNumDataDao;
import com.xu.manager.dao.UserDao;

public class main {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:*spring-mybatis.xml");
		PdByNumDataDao deal = (PdByNumDataDao) app.getBean("pdByNumDataDao");
		;
		System.out.println(deal.query().get(1).getName());
	//	System.out.println(deal.query().get(1).getNumber());
		System.out.println();
	}

}
