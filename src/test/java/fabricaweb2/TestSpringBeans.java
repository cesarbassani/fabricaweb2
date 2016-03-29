package fabricaweb2;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Cesar on 09/03/2016.
 */
public class TestSpringBeans {

    //@Test
    public void testContextoSpring() {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");

        BasicDataSource dataSource = (BasicDataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getPassword() + " " + dataSource.getUsername());

        ctx.close();
    }
}
