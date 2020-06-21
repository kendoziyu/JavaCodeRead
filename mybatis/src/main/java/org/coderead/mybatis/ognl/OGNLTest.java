package org.coderead.mybatis.ognl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.coderead.mybatis.ognl.beans.AgeMethod;
import org.coderead.mybatis.ognl.mappers.OgnlMapper;
import org.junit.Before;
import org.junit.Test;

/**
 * 描述: OGNL（Object Graph Navigation Language）
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/21 0021 <br>
 */
public class OGNLTest {

    private SqlSessionFactory factory;

    @Before
    public void init() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(this.getClass().getResourceAsStream("/mybatis/ognl/mybatis-config.xml"));
    }

    @Test
    public void ognlStaticMethod() {
        OgnlMapper mapper = factory.openSession().getMapper(OgnlMapper.class);
        mapper.testStaticMethod("mock");
    }

    @Test
    public void ognlMemberMethod() {
        OgnlMapper mapper = factory.openSession().getMapper(OgnlMapper.class);
        AgeMethod method = new AgeMethod();
        System.out.println(mapper.testMemberMethod(method, 10));
    }

    @Test
    public void ognlStaticField() {
        OgnlMapper mapper = factory.openSession().getMapper(OgnlMapper.class);
        System.out.println(mapper.testStaticField());
    }
}
