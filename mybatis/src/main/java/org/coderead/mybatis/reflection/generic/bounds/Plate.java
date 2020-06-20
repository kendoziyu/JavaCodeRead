package org.coderead.mybatis.reflection.generic.bounds;

/**
 * 描述:  {@link "https://blog.csdn.net/javaQQ561487941/article/details/90694010"}<br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/20 0020 <br>
 */
public class Plate<T> {

    private T item;
    public Plate(T t) {
        item = t;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
