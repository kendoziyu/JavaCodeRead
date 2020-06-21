package org.coderead.mybatis.ognl.mappers;

import org.apache.ibatis.annotations.Select;
import org.coderead.mybatis.beans.User;
import org.coderead.mybatis.ognl.beans.AgeMethod;

/**
 * 描述:  测试 OGNL 的 Mapper <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/21 0021 <br>
 */
public interface OgnlMapper {

    User testStaticMethod(String name);

    User testMemberMethod(AgeMethod ageMethod, int age);

    User testStaticField();
}
