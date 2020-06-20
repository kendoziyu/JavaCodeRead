package org.coderead.mybatis.reflection.generic;

import org.coderead.mybatis.reflection.generic.beans.GenericClass;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParameterizedTypeTest {

    @Test
    public void test1() throws NoSuchMethodException {
        Method toSet = Collectors.class.getMethod("toSet");
        // Collector<T, ?, Set<T>>
        ParameterizedType returnType = (ParameterizedType) toSet.getGenericReturnType();
        System.out.println("rawType: " + returnType.getRawType());
        for (Type type : returnType.getActualTypeArguments()) {
            System.out.println(type.getClass());
        }
    }

    /**
     * getOwnType例子
     * @throws NoSuchMethodException
     */
    @Test
    public void test2() throws NoSuchMethodException {
        Method set = ParameterizedTypeTest.class.getMethod("set", GenericClass.Inner.class);
        Type[] params = set.getGenericParameterTypes();
        ParameterizedType param1 = (ParameterizedType) params[0];
        System.out.println(param1.getOwnerType().toString());
        System.out.println(param1.getRawType().toString());
    }

    public <T> void set(GenericClass<T>.Inner<T> data) {

    }


}
