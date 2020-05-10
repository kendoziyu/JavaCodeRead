package cn.skilled.peon.mybatis;

import cn.skilled.peon.mybatis.beans.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = factoryBuilder.build(MyBatisTest.class.getResourceAsStream("/mybatis-config.xml"));
    }

    @Test
    public void testSelect() {
        SqlSession session = sqlSessionFactory.openSession();

        String statementId = "cn.skilled.peon.mybatis.UserMapper.selectByid";
        User user = session.selectOne(statementId, 1);
        System.out.println(user);
    }

    @Test
    public void testProxy() {
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectByid(1);
        System.out.println(user);
    }
}
