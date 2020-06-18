package org.coderead.mybatis.reflection.methods.bridge;

import org.coderead.mybatis.reflection.methods.util.PrintUtil;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 描述: 桥接方法测试 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/17 0017 <br>
 */
public class BridgeMethodsTest {

    @Test
    public void test1() {
        System.out.println("----------Consumer----------");
        PrintUtil.printMethods(Consumer.class.getMethods(), true);
        System.out.println("----------StringConsumer----------");
        PrintUtil.printMethods(StringConsumer.class.getMethods(), true);
    }

    @Test
    public void test2() {
        System.out.println("----------Supplier----------");
        PrintUtil.printMethods(Supplier.class.getMethods(), true);
        System.out.println("----------StringSupplier----------");
        PrintUtil.printMethods(StringSupplier.class.getMethods(), true);
    }

    @Test
    public void test3() {
        System.out.println("----------Function----------");
        PrintUtil.printMethods(Function.class.getMethods(), true);
        System.out.println("----------StringFunction----------");
        PrintUtil.printMethods(StringFunction.class.getMethods(), true);
    }

    @Test
    public void test4() {
        System.out.println("----------BaseConsumer----------");
        PrintUtil.printMethods(BaseConsumer.class.getMethods(), true);
        System.out.println("----------IntegerConsumer----------");
        PrintUtil.printMethods(IntegerConsumer.class.getMethods(), true);
    }

    @Test
    public void test5() {
        System.out.println("----------BaseSupplier----------");
        PrintUtil.printMethods(BaseSupplier.class.getMethods(), true);
        System.out.println("----------IntegerSupplier----------");
        PrintUtil.printMethods(IntegerSupplier.class.getMethods(), true);
    }

    @Test
    public void test6() {
        System.out.println("----------BaseFunction----------");
        PrintUtil.printMethods(BaseFunction.class.getMethods(), true);
        System.out.println("----------IntegerFunction----------");
        PrintUtil.printMethods(IntegerFunction.class.getMethods(), true);
    }

    @Test
    public void test7() {
        System.out.println("----------BasePrinter----------");
        PrintUtil.printMethods(BasePrinter.class.getDeclaredMethods(), true);
        System.out.println("----------PublicPrinter----------");
        PrintUtil.printMethods(PublicPrinter.class.getDeclaredMethods(), true);
    }

    @Test
    public void test8() {
        System.out.println("----------SuperClass----------");
        PrintUtil.printMethods(SuperClass.class.getDeclaredMethods(), true);
        System.out.println("----------SubClass----------");
        PrintUtil.printMethods(SubClass.class.getDeclaredMethods(), true);
    }

    @Test
    public void test9() {
        Function func = new StringFunction();
        System.out.println(func.apply(new Object()));
    }
}
