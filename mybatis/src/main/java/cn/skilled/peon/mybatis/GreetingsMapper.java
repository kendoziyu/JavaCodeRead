package cn.skilled.peon.mybatis;

import cn.skilled.peon.mybatis.beans.User;
import org.apache.ibatis.annotations.Select;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/1 0001 <br>
 */
public interface GreetingsMapper {

    @Select({" select words from greetings where id=#{1}"})
    String selectByid(Integer id);
}
