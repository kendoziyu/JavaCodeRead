package org.coderead.mybatis.reflection.generic.beans;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class GenericSample1<T1, T2> {

    public <T3, T4> GenericSample1(T3 t3, T4 t4) {

    }

    public <T5,T6> T6 test(T5 t5) {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // 从类中获取 TypeVariable
        TypeVariable<Class<GenericSample1>>[] typeParameters = GenericSample1.class.getTypeParameters();

        // 从构造函数中获取 TypeVariable
        Constructor<GenericSample1> constructor = GenericSample1.class.getConstructor(Object.class, Object.class);
        TypeVariable<Constructor<GenericSample1>>[] typeParameters1 = constructor.getTypeParameters();

        // 从方法中获取 TypeVariable
        Method test = GenericSample1.class.getMethod("test", Object.class);
        TypeVariable<Method>[] typeParameters2 = test.getTypeParameters();

        System.out.println();
    }
}
