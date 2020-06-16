package org.coderead.mybatis.reflection;

import org.junit.Test;

/**
 * 描述: 测试 {@link Class#getCanonicalName()}, {@link Class#getSimpleName()} {@link Class#getTypeName()} <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/16 0016 <br>
 */
public class NameTest {

    /**
     * 数组
     */
    @Test
    public void test1() {
        String[][][] array = new String[0][][];
        // java.lang.String[][][]
        System.out.println(array.getClass().getCanonicalName());
    }

    class Inner1 {
        class Inner2 {
            class Inner3 {

            }
        }
    }

    /**
     * 成员内部类
     */
    @Test
    public void test2() {
        // org.coderead.mybatis.reflection.NameTest$Inner1$Inner2$Inner3
        System.out.println(Inner1.Inner2.Inner3.class.getName());
        // Inner3
        System.out.println(Inner1.Inner2.Inner3.class.getSimpleName());
        // org.coderead.mybatis.reflection.NameTest.Inner1.Inner2.Inner3
        System.out.println(Inner1.Inner2.Inner3.class.getCanonicalName());
    }

    /**
     * anonymous classes
     * 匿名内部类
     */
    @Test
    public void test3() {
        Runnable test3 = new Runnable() {
            @Override
            public void run() {

            }
        };

        System.out.println(test3.getClass().getName()); // org.coderead.mybatis.reflection.NameTest$1
        System.out.println(test3.getClass().getSimpleName()); // ""
        System.out.println(test3.getClass().getCanonicalName()); // null
    }

    /**
     * local classes
     */
    @Test
    public void test4() {
        class Mega {

        }

        System.out.println(Mega.class.getName()); // org.coderead.mybatis.reflection.NameTest$1Mega
        System.out.println(Mega.class.getSimpleName()); // Mega
        System.out.println(Mega.class.getCanonicalName()); // null
    }

    @Test
    public void test5() throws ClassNotFoundException {
        // boolean[] 基础类型数组
        Class booleanArray = Class.forName("[Z");
        System.out.println(booleanArray.getName());
        // Boolean[] 数组
        Class booleanArray2 = Class.forName("[Ljava.lang.Boolean;");
        System.out.println(booleanArray2.getName());
        System.out.println(booleanArray.equals(booleanArray2));
    }

    /**
     * 使用相同的 {@link ClassLoader} 加载的类对象是同一个
     * @throws ClassNotFoundException
     */
    @Test
    public void test6() throws ClassNotFoundException {
        Class booleanArray = Class.forName("[Z");
        Class booleanArray2 = Class.forName("[Z");
        System.out.println(booleanArray.equals(booleanArray2)); // true
    }


}
