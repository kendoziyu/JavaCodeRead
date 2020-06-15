package org.coderead.mybatis.reflection.methods.util;

import java.lang.reflect.Method;

/**
 * 描述: 拿出 {@link org.apache.ibatis.reflection.Reflector} 中的部分私有方法 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/15 0015 <br>
 */
public class ReflectorUtils {

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
