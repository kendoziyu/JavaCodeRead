package cn.skilled.peon.mybatis;

import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述: 测试Mybatis中的执行器 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/5/30 0030 <br>
 */
public class ExecutorTest {

    private SqlSessionFactory sqlSessionFactory;

    private Configuration configuration;
    private JdbcTransaction jdbcTransaction;
    private MappedStatement mappedStatement;

    @Before
    public void init() {
        // 获取SqlSession构造器
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        // 加载配置文件
        sqlSessionFactory = factoryBuilder.build(MyBatisTest.class.getResourceAsStream("/mybatis-config.xml"));

        configuration = sqlSessionFactory.getConfiguration();
        jdbcTransaction = new JdbcTransaction(sqlSessionFactory.openSession().getConnection());
        mappedStatement = configuration.getMappedStatement("cn.skilled.peon.mybatis.UserMapper.selectByid");
    }


    @Test
    public void simpleExecutor() throws SQLException {
        SimpleExecutor simpleExecutor = new SimpleExecutor(configuration, jdbcTransaction);
        List<Object> list = simpleExecutor.doQuery(mappedStatement, 10, RowBounds.DEFAULT,
                SimpleExecutor.NO_RESULT_HANDLER, mappedStatement.getBoundSql(10));
        simpleExecutor.doQuery(mappedStatement, 10, RowBounds.DEFAULT,
                SimpleExecutor.NO_RESULT_HANDLER, mappedStatement.getBoundSql(10));
        System.out.println(list);
    }

    /**
     * 相同的sql只执行一次
     * @throws SQLException
     */
    @Test
    public void reuseExecutor() throws SQLException {
        ReuseExecutor reuseExecutor = new ReuseExecutor(configuration, jdbcTransaction);
        List<Object> list = reuseExecutor.doQuery(mappedStatement, 10, RowBounds.DEFAULT,
                SimpleExecutor.NO_RESULT_HANDLER, mappedStatement.getBoundSql(10));
        reuseExecutor.doQuery(mappedStatement, 10, RowBounds.DEFAULT,
                SimpleExecutor.NO_RESULT_HANDLER, mappedStatement.getBoundSql(10));
        reuseExecutor.doQuery(mappedStatement, 20, RowBounds.DEFAULT,
                SimpleExecutor.NO_RESULT_HANDLER, mappedStatement.getBoundSql(20));
        System.out.println(list);
    }

    /**
     * 对修改和新增有效
     * @throws SQLException
     */
    @Test
    public void batchExecutor() throws SQLException {
        BatchExecutor batchExecutor = new BatchExecutor(configuration, jdbcTransaction);
        MappedStatement mappedStatement = configuration.getMappedStatement(
                "cn.skilled.peon.mybatis.UserMapper.setName"
        );
        Map<String, Object> params = new HashMap<>();
        params.put("arg0", 10);
        params.put("arg1", "luban is good man.");
        batchExecutor.doUpdate(mappedStatement, params);
        batchExecutor.doUpdate(mappedStatement, params);
        batchExecutor.doFlushStatements(false);
    }
}
