package cn.skilled.peon.mybatis;

import cn.skilled.peon.mybatis.beans.User;
import org.apache.ibatis.annotations.*;

@CacheNamespace
public interface UserMapper {

    @Select({" select * from users where id=#{1}"})
    User selectByid(Integer id);

    User selectByid2(Integer id);

    int editUser(User user);

    @Insert({"insert into `users` (`id`, `name`, `age`, `sex`, `email`, `phone_number`, `create_time`) values(#{args0},'用户4','18','女',NULL,NULL,NOW());"})
    void insertNoFlushCache(Integer id);

    @Update("update  users set name=#{arg1} where id=#{arg0}")
    int setName(Integer id, String name);
}
