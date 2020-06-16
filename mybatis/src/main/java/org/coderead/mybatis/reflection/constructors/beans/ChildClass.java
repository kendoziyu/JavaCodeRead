package org.coderead.mybatis.reflection.constructors.beans;

/**
 * 描述: 包含四种不同访问限定符 public / protected / default / private 修饰的四个构造函数 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/14 0014 <br>
 */
public class ChildClass extends ParentClass {

    public ChildClass() {
    }

    protected ChildClass(int i) {

    }
    ChildClass(Integer ii) {

    }

    private ChildClass(Object obj) {

    }
}
