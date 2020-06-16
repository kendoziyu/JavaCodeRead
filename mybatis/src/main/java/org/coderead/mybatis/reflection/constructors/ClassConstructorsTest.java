package org.coderead.mybatis.reflection.constructors;

import org.coderead.mybatis.reflection.constructors.beans.AbstractClass;
import org.coderead.mybatis.reflection.constructors.beans.ChildClass;
import org.coderead.mybatis.reflection.constructors.beans.GenericString;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 描述: 测试构造函数的反射 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/14 0014 <br>
 */
public class ClassConstructorsTest {

    /**
     * {@link Class#getConstructors()} 只返回 当前类的 公有{@code public}构造函数
     * {@link Class#getDeclaredConstructors()} 返回 当前类的 所有构造函数
     * 共同点：两者都不返回 超类的构造函数
     */
    @Test
    public void test1() {
        Constructor[] constructors = ChildClass.class.getConstructors();
        printConstructors(constructors);
        System.out.println("===========================");
        Constructor[] declaredConstructors = ChildClass.class.getDeclaredConstructors();
        printConstructors(declaredConstructors);
    }

    /**
     * 抽象类 可以获取到构造函数
     */
    @Test
    public void test2() {
        Constructor[] abstractClassConstructors = AbstractClass.class.getConstructors();
        printConstructors(abstractClassConstructors);
        Constructor[] abstractClassDeclaredConstructors = AbstractClass.class.getDeclaredConstructors();
        printConstructors(abstractClassDeclaredConstructors);
    }

    /**
     * 没有构造函数的情况:
     * 1. 数组类
     * 2. void
     * 3. primitives
     *
     * {@link Class#getConstructors()} 可以获取到 private/protected/default/public 修饰的构造函数,
     * 但是 {@link Class#getDeclaredConstructors()} 只能获取 public 修饰的构造函数
     */
    @Test
    public void test3() {
        // 数组对象没有构造函数
        Assert.assertEquals(Object[].class.getConstructors().length, 0);
        Assert.assertEquals(Object[].class.getDeclaredConstructors().length, 0);
        // void 没有构造函数
        Assert.assertEquals(void.class.getConstructors().length, 0);
        Assert.assertEquals(void.class.getDeclaredConstructors().length, 0);
        // Primitives 原始类型没有构造函数
        Assert.assertEquals(int.class.getConstructors().length, 0);
        Assert.assertEquals(int.class.getDeclaredConstructors().length, 0);
        // 接口类 没有构造函数
        Assert.assertEquals(Runnable.class.getConstructors().length, 0);
        Assert.assertEquals(Runnable.class.getDeclaredConstructors().length, 0);
        // 如果没有 public Constructor, 那么 getConstructors() 返回也是0
        Assert.assertEquals(System.class.getConstructors().length, 0);
        // 但是 getDeclaredConstructors() 是能够获取到 private/default/protected 修饰的构造函数的
        Assert.assertEquals(System.class.getDeclaredConstructors().length, 1);
       printConstructors(System.class.getDeclaredConstructors());
    }

    /**
     * 泛型, 子类需要擦除泛型类的。
     * 构造函数中未指明类型的参数，会用 {@link Object} 来代替
     */
    @Test
    public void test4() {
        System.out.println("---------getConstructors()---------");
        printConstructors(GenericString.class.getConstructors());
        System.out.println("---------getDeclaredConstructors()---------");
        printConstructors(GenericString.class.getDeclaredConstructors());
    }
    private void printConstructors(Constructor[] constructors) {
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toString());
        }
    }
}
