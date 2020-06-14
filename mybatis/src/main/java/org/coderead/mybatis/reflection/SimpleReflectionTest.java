package org.coderead.mybatis.reflection;

import org.coderead.mybatis.beans.User;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 描述: 使用最基础的 API 反射<br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/14 0014 <br>
 */
public class SimpleReflectionTest {

    @Test
    public void reflectionTest1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object user = new User();
        Method setName = user.getClass().getDeclaredMethod("setName", String.class);
        setName.invoke(user, "hello world");
        Method getName = user.getClass().getDeclaredMethod("getName");
        Object name = getName.invoke(user);
        System.out.println(name);
    }
}
