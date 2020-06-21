package org.coderead.mybatis.boundsql.mappers;

import org.apache.ibatis.annotations.Select;
import org.coderead.mybatis.beans.User;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/21 0021 <br>
 */
public interface UserMapper {

    @Select("select * from user where name=#{name} and age=#{age}")
    User getUserByNameAndAge(String name, int age);

    User getUser(User user);

}
