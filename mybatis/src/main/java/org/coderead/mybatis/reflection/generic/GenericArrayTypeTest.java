package org.coderead.mybatis.reflection.generic;

import org.junit.Test;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.util.function.Function;

public class GenericArrayTypeTest {

    /**
     * OwnType例子
     * @throws NoSuchMethodException
     */
    @Test
    public void test2() throws NoSuchMethodException {
        Method set = GenericArrayTypeTest.class.getMethod("getFunc");
        GenericArrayType param = (GenericArrayType) set.getGenericReturnType();
        System.out.println(param.getGenericComponentType());

    }

    public <T,R> Function<T,R>[] getFunc() {
        return null;
    }
}
