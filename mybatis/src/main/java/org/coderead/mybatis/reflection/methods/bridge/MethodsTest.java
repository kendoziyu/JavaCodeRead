package org.coderead.mybatis.reflection.methods.bridge;

import org.coderead.mybatis.reflection.methods.util.ReflectorUtils;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 描述: 打印方法<br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/16 0016 <br>
 */
public class MethodsTest {

    /**
     * 子类 覆盖了 父类的方法，并且进一步限定了返回参数的类型，那么父类的方法会成为子类的 桥接函数 Bridge Method
     * 此规则不适用于静态函数！如{@link StringFactory#staticMethod()}
     */
    @Test
    public void test1() {
        System.out.println("---------getMethods() --- excluded Object methods ---------");
        printMethods(StringFactory.class.getMethods(), true);
    }

    /**
     * 子类复写了父类的方法
     */
    @Test
    public void test2() {
        GenericFactory factory = new StringFactory();
        System.out.println(factory.product());

    }

    /**
     * 子类函数 改变 父类 同名函数的 参数类型，会重新生成一个新的函数，不会覆盖父类函数。
     *
     * 这里返回的是 {@code "GenericFactory"} 而不是调用对象实例方法 {@link StringFactory#changeFrom(String)}
     * 调用方法时，优先到 指定的引用类中 寻找方法
     */
    @Test
    public void test3() {
        GenericFactory factory = new StringFactory();
        System.out.println(factory.changeFrom("")); // GenericFactory
        System.out.println(factory.staticMethod());

        StringFactory factory2 = new StringFactory();
        // 强制转换
        System.out.println(((GenericFactory)factory2).changeFrom("")); // GenericFactory

        System.out.println(factory2.changeFrom("")); // StringFactory
    }

    private void printMethods(Method[] methods, boolean excludeObjectMethods) {
        for (Method method : methods) {
            if (excludeObjectMethods && method.getDeclaringClass() == Object.class) {
                continue;
            }
            System.out.println(method.getDeclaringClass().getSimpleName() + " " + ReflectorUtils.getSignature(method) + (method.isBridge() ? " is Bridge!" : ""));
        }
    }
}
