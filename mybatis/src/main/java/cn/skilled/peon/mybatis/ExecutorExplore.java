package cn.skilled.peon.mybatis;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/1 0001 <br>
 */
public class ExecutorExplore {

    private SqlSessionFactory sqlSessionFactory;

    /**
     * 使用xml配置文件初始化
     */
    @Before
    public void initByXML() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(ExecutorExplore.class.getResourceAsStream("/mybatis-config.xml"));
    }

//    @Before
    public void initByJava() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);

        Configuration configuration = new Configuration();
        configuration.addMapper(GreetingsMapper.class);
        configuration.addMapper(UserMapper.class);
        builder.build(configuration);
    }

    @Test
    public void selectOne() {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.REUSE, true);
        sqlSession.selectOne("selectByid", 10);
    }
}
