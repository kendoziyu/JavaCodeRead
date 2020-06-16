package org.coderead.mybatis.reflection.methods.util;

import java.lang.reflect.Method;

/**
 * 描述: 拿出 {@link org.apache.ibatis.reflection.Reflector} 中的部分私有方法来做测试
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/15 0015 <br>
 */
public class ReflectorUtils {

    /**
     * 获取方法的唯一签名
     * 返回类型#方法名#参数1类型,参数2类型,...,参数n类型
     *
     * @param method 方法信息
     * @return
     */
    public static String getSignature(Method method) {
        StringBuilder sb = new StringBuilder();
        Class<?> returnType = method.getReturnType();
        if (returnType != null) {
            sb.append(returnType.getName()).append('#');
        }
        sb.append(method.getName());
        Class<?>[] parameters = method.getParameterTypes();
        for (int i = 0; i < parameters.length; i++) {
            if (i == 0) {
                sb.append(':');
            } else {
                sb.append(',');
            }
            sb.append(parameters[i].getName());
        }
        return sb.toString();
    }
}
