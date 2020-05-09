package cn.skilled.peon.mybatis;

import cn.skilled.peon.mybatis.beans.User;
import org.apache.ibatis.annotations.*;


@CacheNamespace(blocking=true)
public interface UserMapper {

    @Select({" select * from users where id=#{1}"})
    User selectByid(Integer id);

    int editUser(User user);

}
