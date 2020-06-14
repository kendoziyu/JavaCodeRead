package org.coderead.mybatis.reflection.methods.beans;

/**
 * 描述:  继承 {@link TestableParent} 且实现 {@link Testable} 接口的子类<br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/14 0014 <br>
 */
public class TestableChild extends TestableParent implements Testable {
    @Override
    public void test() {
        System.out.println("test child");
    }
}
