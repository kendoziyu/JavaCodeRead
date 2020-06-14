package org.coderead.mybatis.reflection.fields;

import org.coderead.mybatis.reflection.fields.beans.Child;
import org.coderead.mybatis.reflection.fields.beans.Empty;
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

    @Test
    public void test0() {
        Field[] fields = Child.class.getFields();
        printFields(fields);
        System.out.println("===========================");
        Field[] declaredFields = Child.class.getDeclaredFields();
        printFields(declaredFields);
    }

    @Test
    public void test1() {
        // Class对象描述的是数组类型
        Field[] arrayFields = Object[].class.getFields();
        Assert.assertEquals(arrayFields.length, 0);
        Field[] arrayDeclaredFields = Object[].class.getDeclaredFields();
        Assert.assertEquals(arrayDeclaredFields.length, 0);

        // Class对象描述的是基本类型
        Field[] intFields = int.class.getFields();
        Assert.assertEquals(intFields.length, 0);
        Field[] intDeclaredFields = int.class.getFields();
        Assert.assertEquals(intDeclaredFields.length, 0);

        // 类中没有成员变量
        Field[] fields = Empty.class.getFields();
        Assert.assertEquals(fields.length, 0);
        Field[] declaredFields = Empty.class.getDeclaredFields();
        Assert.assertEquals(declaredFields.length, 0);
    }

    private void printFields(Field[] fields) {
        for (Field field : fields) {
            System.out.println(field.toString());
        }
    }
}
