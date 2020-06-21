package org.coderead.mybatis.ognl.beans;

public class AgeMethod {

    int age = 1;

    public int increaseAge(int age) {
        return this.age + age;
    }

}
