package org.coderead.mybatis.reflection.constructors;

import org.coderead.mybatis.reflection.constructors.beans.AbstractClassConstructor;
import org.coderead.mybatis.reflection.constructors.beans.ChildConstruction;
import org.coderead.mybatis.reflection.constructors.beans.InterfaceNoConstructor;
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
     * 注意 {@link Class#getConstructors()} 只返回 当前类的 公有构造函数，不返回 超类的构造函数
     * {@link Class#getDeclaredConstructors()} 返回 当前类的 所有构造函数，不返回 超类的构造函数
     */
    @Test
    public void test0() {
        Constructor[] constructors = ChildConstruction.class.getConstructors();
        printConstructors(constructors);
        System.out.println("===========================");
        Constructor[] declaredConstructors = ChildConstruction.class.getDeclaredConstructors();
        printConstructors(declaredConstructors);
    }

    @Test
    public void test1() {
        Constructor[] constructors = InterfaceNoConstructor.class.getConstructors();
        Assert.assertEquals(constructors.length, 0);
        Constructor[] declaredConstructors = InterfaceNoConstructor.class.getDeclaredConstructors();
        Assert.assertEquals(declaredConstructors.length, 0);

        Constructor[] abstractClassConstructors = AbstractClassConstructor.class.getConstructors();
        printConstructors(abstractClassConstructors);
        Constructor[] abstractClassDeclaredConstructors = AbstractClassConstructor.class.getDeclaredConstructors();
        printConstructors(abstractClassDeclaredConstructors);
    }

    private void printConstructors(Constructor[] constructors) {
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toString());
        }
    }
}
