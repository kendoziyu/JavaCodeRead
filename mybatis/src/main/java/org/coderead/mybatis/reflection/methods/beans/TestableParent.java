package org.coderead.mybatis.reflection.methods.beans;

/**
 * 描述: 实现 {@link Testable} 接口的父类 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/14 0014 <br>
 */
public class TestableParent implements Testable {

    @Override
    public void test() {
        System.out.println("parent test");
    }
}
