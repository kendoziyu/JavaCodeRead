package org.coderead.mybatis.reflection.fields;

import org.coderead.mybatis.reflection.fields.beans.Child;
import org.coderead.mybatis.reflection.fields.beans.Constants;
import org.coderead.mybatis.reflection.fields.beans.NoFieldsClass;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 *  描述: {@link Class} 中有 {@link Class#getFields()} 和 {@link Class#getDeclaredFields()} 两种反射方法来获取 类的成员<br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/14 0014 <br>
 */
public class ClassFieldTest {

    /**
     * {@link Class#getFields()} 只获取 {@code public} 公有成员变量，包含 超类的公有成员变量
     * {@link Class#getDeclaredFields()} 获取 当前类的 所有成员变量，不包含 超类的公有成员变量
     */
    @Test
    public void test1() {
        System.out.println("----------getFields()----------");
        printFields(Child.class.getFields());
        System.out.println("----------getDeclaredFields()----------");
        printFields(Child.class.getDeclaredFields());
    }

    /**
     * 没有域的情况：
     * 1. 原始类型
     * 2. 数组类型
     * 3. void
     * 4. 类或者接口中没有声明域
     *
     * 假如有一个 域不是 公有 {@code public} 的，那么 {@link Class#getFields()} 获取不到， 但是 {@link Class#getDeclaredFields()} 可以获取到
     */
    @Test
    public void test2() {
        // 数组对象的域 个数 == 0
        Assert.assertEquals(Object[].class.getFields().length, 0);
        Assert.assertEquals(Object[].class.getDeclaredFields().length, 0);
        // 基本类型的域 个数 == 0
        Assert.assertEquals(int.class.getFields().length, 0);
        Assert.assertEquals(int.class.getDeclaredFields().length, 0);
        // 类或者接口中没有域，则 域个数 == 0
        Assert.assertEquals(NoFieldsClass.class.getFields().length, 0);
        Assert.assertEquals(NoFieldsClass.class.getDeclaredFields().length, 0);
        // void 没有域
        Assert.assertEquals(void.class.getFields().length, 0);
        Assert.assertEquals(void.class.getDeclaredFields().length, 0);
        // 相反地，接口中如果定义了域，则 域个数 > 0
        Assert.assertTrue(Constants.class.getFields().length > 0);
        Assert.assertTrue(Constants.class.getDeclaredFields().length > 0);
    }

    private void printFields(Field[] fields) {
        for (Field field : fields) {
            System.out.println(field.toString());
        }
    }
}
