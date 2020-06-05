package cn.skilled.peon.mybatis;

import cn.skilled.peon.mybatis.beans.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 描述: Spring 集成 Mybatis 时 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/5 0005 <br>
 */
public class SpringSqlSessionTest {

    @Test
    public void openTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        DataSourceTransactionManager txManager = (DataSourceTransactionManager) context.getBean("txManager");
        // 手动开启事务
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
        User user3 = userMapper.selectByid(10);
        User user4 = userMapper.selectByid(10);
        System.out.println(user3 == user4);
    }

    @Test
    public void noTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        // 没有开启事务时不相等
        User user1 = userMapper.selectByid(10);
        User user2 = userMapper.selectByid(10);
        System.out.println(user1 == user2);
    }

}
