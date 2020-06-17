package org.coderead.mybatis.reflection.methods.bridge;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/16 0016 <br>
 */
public class GenericFactory<T> {

    public T createOne() {
        return null;
    }

    public Object create() {
        return new Object();
    }

    public Object changeFrom(Object src) {
        return "GenericFactory";
    }

    public Object product() {
        return "generic";
    }

    public static <K> Object convert(K t) {
        return t;
    }

    public static Object staticMethod() {
        return "gg";
    }
}
