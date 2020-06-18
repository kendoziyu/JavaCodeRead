package org.coderead.mybatis.reflection.methods.util;

import java.lang.reflect.Method;

/**
 * 描述: 打印反射的类信息  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/17 0017 <br>
 */
public class PrintUtil {

    /**
     * 打印方法信息
     * @param methods 方法数组
     * @param excludeObjectMethods {@code true} 排除Object中的方法
     */
    public static void printMethods(Method[] methods, boolean excludeObjectMethods) {
        for (Method method : methods) {
            if (excludeObjectMethods && method.getDeclaringClass() == Object.class) {
                continue;
            }
            System.out.println(method.getDeclaringClass().getSimpleName() + " " + ReflectorUtils.getSignature(method) + (method.isBridge() ? " is Bridge!" : ""));
        }
    }

}
