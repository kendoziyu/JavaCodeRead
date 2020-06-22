package org.coderead.mybatis.ognl.beans;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/22 0022 <br>
 */
public class TestUser {

    private String name;

    private String id;

    private int age;

    public TestUser() {
    }

    public TestUser(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public TestUser(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println(name + " say hello to you!");
    }
}
