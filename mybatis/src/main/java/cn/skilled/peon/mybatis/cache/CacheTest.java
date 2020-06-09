package cn.skilled.peon.mybatis.cache;

import cn.skilled.peon.mybatis.MyBatisTest;
import cn.skilled.peon.mybatis.UserMapper;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/6 0006 <br>
 */
public class CacheTest {

    private SqlSessionFactory factory;
    private Configuration configuration;

    @Before
    public void init() {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        factory = factoryBuilder.build(MyBatisTest.class.getResourceAsStream("/mybatis-config.xml"));
        configuration = factory.getConfiguration();
    }

    /**
     * {@link org.apache.ibatis.cache.decorators.SerializedCache}
     */
    @Test
    public void isSerializeImportant() {
        Cache cache = configuration.getCache(UserMapper.class.getName());

    }


    /**
     * 如果 @Options(flushCache = Options.FlushCachePolicy.TRUE)， selectByid 仍然会命中缓存
     */
    @Test
    public void hitCache() {
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.selectByid(10);
        sqlSession.commit();

        SqlSession sqlSession2 = factory.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        userMapper2.selectByid(10);
        sqlSession2.commit();

        SqlSession sqlSession3 = factory.openSession();
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        userMapper3.selectByid(10);
        sqlSession3.commit();
    }
}
