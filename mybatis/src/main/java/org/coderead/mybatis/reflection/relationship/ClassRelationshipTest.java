package org.coderead.mybatis.reflection.relationship;

import org.coderead.mybatis.reflection.relationship.beans.SubClass;
import org.coderead.mybatis.reflection.relationship.beans.SubInterface;
import org.coderead.mybatis.reflection.relationship.beans.SuperClass;
import org.coderead.mybatis.reflection.relationship.beans.SuperInterface;
import org.junit.Assert;
import org.junit.Test;

public class ClassRelationshipTest {

    /**
     * 子类与父类的关系
     * 父类 isAssignableFrom 子类
     */
    @Test
    public void test1() {
        Assert.assertTrue(SuperClass.class.isAssignableFrom(SubClass.class));
        Assert.assertTrue(SuperClass.class.isAssignableFrom(SuperClass.class));
        Assert.assertFalse(SubClass.class.isAssignableFrom(SuperClass.class));
    }

    /**
     * 对象 instanceOf 类
     */
    @Test
    public void test2() {
        SuperClass obj = new SubClass();
        Assert.assertTrue(obj instanceof SubClass);
        Assert.assertTrue(obj instanceof SuperClass);
    }

    /**
     * 接口与接口的继承关系
     */
    @Test
    public void test3() {
        Assert.assertTrue(SuperInterface.class.isAssignableFrom(SubInterface.class));
        Assert.assertTrue(SuperInterface.class.isAssignableFrom(SubInterface.class));
        Assert.assertFalse(SubInterface.class.isAssignableFrom(SuperInterface.class));
    }

    @Test
    public void test4() {
        Assert.assertTrue(Object.class.isAssignableFrom(SubInterface.class));
    }
}
