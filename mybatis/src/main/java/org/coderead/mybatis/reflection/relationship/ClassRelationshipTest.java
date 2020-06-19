package org.coderead.mybatis.reflection.relationship;

import org.coderead.mybatis.reflection.relationship.beans.SubClass;
import org.coderead.mybatis.reflection.relationship.beans.SuperClass;
import org.junit.Assert;
import org.junit.Test;

public class ClassRelationshipTest {

    @Test
    public void test1() {
        Assert.assertTrue(SuperClass.class.isAssignableFrom(SubClass.class));
        Assert.assertTrue(SuperClass.class.isAssignableFrom(SuperClass.class));
    }


    @Test
    public void test2() {
        SuperClass obj = new SubClass();
        Assert.assertTrue(obj instanceof SubClass);
        Assert.assertTrue(obj instanceof SuperClass);
    }
}
