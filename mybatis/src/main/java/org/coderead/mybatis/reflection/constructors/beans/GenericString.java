package org.coderead.mybatis.reflection.constructors.beans;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/16 0016 <br>
 */
public class GenericString<K> extends GenericClass<String> {

    public GenericString(String s) {
        super(s);
    }

    protected GenericString(String a, K b) {
        super(a);
    }
}
