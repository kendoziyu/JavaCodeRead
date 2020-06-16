package org.coderead.mybatis.reflection.constructors.beans;

/**
 * 描述: {@link GenericClass} 泛型类 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/16 0016 <br>
 */
public class GenericClass<T> {
    T t;
    public GenericClass(T t) {
        this.t = t;
    }
}
