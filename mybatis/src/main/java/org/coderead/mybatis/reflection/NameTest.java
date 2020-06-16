package org.coderead.mybatis.reflection;

import org.coderead.mybatis.reflection.enclosingclass.TopLevelClass;
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

    @Test
    public void test3() throws ClassNotFoundException {
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
    public void test4() throws ClassNotFoundException {
        Class booleanArray = Class.forName("[Z");
        Class booleanArray2 = Class.forName("[Z");
        System.out.println(booleanArray.equals(booleanArray2)); // true
    }

    /**
     * 本地类和匿名类
     */
    @Test
    public void test5() {
        TopLevelClass top = new TopLevelClass(10);
        Class localClass = top.buildLocalClass().getClass();
        System.out.println("------------Local Class------------");
        printAllNames(localClass);

        System.out.println("----------Anonymous Class----------");
        Class anonymousClass = top.buildAnonymousClass().getClass();
        printAllNames(anonymousClass);
    }

    /**
     * 嵌套类和内部类
     */
    @Test
    public void test6() {
        // 嵌套类
        Object nested = new TopLevelClass.NestedClass();
        Class nestedClass = nested.getClass();
        printAllNames(nestedClass);

        // 内部类
        TopLevelClass top = new TopLevelClass(100);
        Object inner = top.new InnerClass();
        Class innerClass = inner.getClass();
        printAllNames(innerClass);
    }

    @Test
    public void test7() {
        // 嵌套类
        Object nested = new TopLevelClass.NestedClass();
        Class nestedClass = nested.getClass();
        printClasses(nestedClass);

        // 顶级类
        TopLevelClass top = new TopLevelClass(100);
        printClasses(top.getClass());

        // 内部类
        Object inner = top.new InnerClass();
        Class innerClass = inner.getClass();
        printClasses(innerClass);
    }

    /**
     * 本地类和匿名类
     */
    @Test
    public void test8() {
        TopLevelClass top = new TopLevelClass(10);
        Class localClass = top.buildLocalClass().getClass();
        System.out.println("------------Local Class------------");
        printClasses(localClass);

        System.out.println("----------Anonymous Class----------");
        Class anonymousClass = top.buildAnonymousClass().getClass();
        printClasses(anonymousClass);
    }

    /**
     * 这个测试的结果和上一个测试其实是一样的,
     * {@link Class#getEnclosingClass()} 可以在 Local Class 和 Anonymous Class 中获取到 类
     * 但是， {@link Class#getDeclaringClass()} 在 Local Class 和 Anonymous Class 中取到的是 null
     */
    @Test
    public void test9() {
        TopLevelClass top = new TopLevelClass(9);
        Runnable runnable = (Runnable) top.buildAnonymousClass();
        runnable.run();
    }

    private void printAllNames(Class cls) {
        System.out.println(cls.getName());
        System.out.println(cls.getCanonicalName());
        System.out.println(cls.getSimpleName());
    }

    private void printClasses(Class cls) {
        System.out.println("EnclosingClass: " + cls.getEnclosingClass());
        System.out.println("DeclaringClass: " + cls.getDeclaringClass());
    }

}
