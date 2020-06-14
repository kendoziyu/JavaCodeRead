package org.coderead.mybatis.reflection.methods;

import org.coderead.mybatis.reflection.methods.beans.*;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 描述: {@link Class} 中有 {@link Class#getMethods} 和 {@link Class#getDeclaredMethods} 两种反射方法来获取 类的函数信息 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/14 0014 <br>
 */
public class ClassMethodsTest {

    /**
     * 接口 和 抽象类 也可以调用 {@link Class#getMethods()} 和 {@link Class#getDeclaredMethods()}
     * 例如：接口类 {@link org.coderead.mybatis.reflection.methods.beans.Testable} 和抽象类 {@link AbstractTest}
     */
    @Test
    public void test0() {
        Method[] interfaceMethods = Testable.class.getMethods();
        printMethods(interfaceMethods);
        System.out.println("==================================");
        Method[] abstractClassMethods = AbstractTest.class.getMethods();
        printMethods(abstractClassMethods);
        System.out.println("==================================");
        Method[] interfaceDeclaredMethods = Testable.class.getDeclaredMethods();
        printMethods(interfaceDeclaredMethods);
        System.out.println("==================================");
        Method[] abstractClassDeclaredMethods = AbstractTest.class.getDeclaredMethods();
        printMethods(abstractClassDeclaredMethods);
    }

    /**
     * 子类 {@link TestableChild} 和 {@link TestableParent} 同时实现了 {@link org.coderead.mybatis.reflection.methods.beans.Testable} 接口，
     * 此时子类调用 {@link Class#getMethods()} 只会获取子类的 test() 实现方法
     */
    @Test
    public void test1() {
        Method[] methods = TestableChild.class.getMethods();
        printMethods(methods);
        System.out.println("==================================");
        Method[] parentMethods = TestableParent.class.getMethods();
        printMethods(parentMethods);
    }

    /**
     * {@link MyChildTest} 实现了 {@link org.coderead.mybatis.reflection.methods.beans.Testable} 接口，
     * {@link AbstractTest} 有一个抽象方法 {@link AbstractTest#test}，
     * {@link MyChildTest} 类调用 {@link Class#getMethods()} 只包含一个 {@link MyChildTest#test()} 方法 并不包含 {@link AbstractTest#test} 方法
     */
    @Test
    public void test2() {
        Method[] methods = MyChildTest.class.getMethods();
        printMethods(methods);
    }

    @Test
    public void test3() throws NoSuchMethodException {
        Method method = MyChildTest.class.getMethod("test");
        System.out.println(method.getDeclaringClass());
        System.out.println("isAbstract:" + Modifier.isAbstract(method.getModifiers()));
    }

    /**
     * {@link Class#getMethod(String, Class[])} 和 {@link Class#getMethods()} 查找范围一致
     * {@link Class#getDeclaredMethod(String, Class[])} 和 {@link Class#getDeclaredMethod(String, Class[])} 查找范围一致
     *
     */
    @Test
    public void test4() {
        try {
            Tiger.class.getMethod("bite");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Tiger.class.getDeclaredMethod("bite");
            System.out.println("Tiger#bite found");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Tiger.class.getMethod("running");
            System.out.println("Animal#running found");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            Tiger.class.getDeclaredMethod("running");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private void printMethods(Method[] methods) {
        for (Method method : methods) {
            System.out.println(method.getDeclaringClass().getSimpleName() + "#" + method.getName() + "#" + method.getReturnType());
        }
    }
}
