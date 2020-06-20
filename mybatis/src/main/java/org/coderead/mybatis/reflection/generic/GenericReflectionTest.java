package org.coderead.mybatis.reflection.generic;

import org.coderead.mybatis.reflection.generic.bounds.*;
import org.coderead.mybatis.reflection.relationship.beans.SubInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;

public class GenericReflectionTest {

    @Test
    public void test1() {
        PrintTypeHelper.printClass(Plate.class);
        PrintTypeHelper.printClass(FruitPlate.class);
    }

    /**
     *
     */
    @Test
    public void getGenericSuperclass() {
        // 非泛型类/接口调用 getSuperClass()
        System.out.println(Food.class.getGenericSuperclass()); // null
        // 泛型接口, 泛型超类为 null
        System.out.println(Consumer.class.getGenericSuperclass()); // null
        // 泛型类
        System.out.println(Plate.class.getGenericSuperclass()); // class java.lang.Object
        System.out.println(FruitPlate.class.getGenericSuperclass()); // ParameterizedTypeImpl
    }

    @Test
    public void getSuperclass() {
        System.out.println(Object.class.getSuperclass());// Object 的超类 null
        System.out.println(Food.class.getSuperclass()); // 接口的超类 null
        System.out.println(void.class.getSuperclass()); // void的超类 null
        System.out.println(int.class.getSuperclass()); // 原始类型的超类 null
        System.out.println(SafeVarargs.class.getSuperclass()); // 注解的超类 null
        System.out.println(Code.class.getSuperclass()); // 注解的超类 null
        System.out.println(Object[].class.getSuperclass()); // 数组的超类 Object
    }
}
