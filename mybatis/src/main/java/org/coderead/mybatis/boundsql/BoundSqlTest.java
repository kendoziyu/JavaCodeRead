package org.coderead.mybatis.boundsql;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.coderead.mybatis.Mock;
import org.coderead.mybatis.beans.User;
import org.coderead.mybatis.boundsql.mappers.UserMapper;
import org.junit.Before;
import org.junit.Test;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/21 0021 <br>
 */
public class BoundSqlTest {

    private SqlSessionFactory factory;

    @Before
    public void init() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(this.getClass().getResourceAsStream("/mybatis/boundsql/mybatis-config.xml"));
    }
}
