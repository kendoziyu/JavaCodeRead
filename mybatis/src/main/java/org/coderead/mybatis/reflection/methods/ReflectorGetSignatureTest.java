package org.coderead.mybatis.reflection.methods;

import org.coderead.mybatis.reflection.methods.signature.ReturnTypes;
import org.coderead.mybatis.reflection.methods.signature.TestSignatureClass;
import org.coderead.mybatis.reflection.methods.signature.TestSignatureInterface;
import org.coderead.mybatis.reflection.methods.util.ReflectorUtils;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 描述: 测试 {@link org.coderead.mybatis.reflection.methods.util.ReflectorUtils} 中的方法 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/15 0015 <br>
 */
public class ReflectorGetSignatureTest {

    @Test
    public void test1() {
        Method[] methods = TestSignatureClass.class.getDeclaredMethods();
        printMethods(methods);
    }

    @Test
    public void test2() {
        Method[] methods = TestSignatureInterface.class.getDeclaredMethods();
        printMethods(methods);
    }

    @Test
    public void test3() {
        Method[] methods = ReturnTypes.class.getDeclaredMethods();
        printMethods(methods);
        // 内部类
        System.out.println(ReturnTypes.inner.class.getName());
    }

    private void printMethods(Method[] methods) {
        for (Method method : methods) {
            System.out.println(ReflectorUtils.getSignature(method));
        }
    }
}