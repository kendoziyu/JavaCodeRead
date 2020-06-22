package org.coderead.mybatis.ognl;

import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;
import org.coderead.mybatis.ognl.beans.CollectionsObject;
import org.coderead.mybatis.ognl.beans.TestUser;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 描述: OGNL 的使用 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/21 0021 <br>
 */
public class OgnlTest {

    @Test
    public void testList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        ExpressionEvaluator expr = new ExpressionEvaluator();
        Assert.assertTrue(expr.evaluateBoolean("[0] == get(0) && [0] == 1", list));
        Assert.assertFalse(expr.evaluateBoolean("isEmpty", list));
    }

    @Test
    public void testMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put(null, 100);
        ExpressionEvaluator expr = new ExpressionEvaluator();
        Assert.assertTrue(expr.evaluateBoolean("[\"key1\"] < get('key2')", map));
        Assert.assertTrue(expr.evaluateBoolean("[key] == 100", map));
    }

    @Test
    public void testArray() {
        int[] array = new int[]{1,2,3};
        ExpressionEvaluator expr = new ExpressionEvaluator();
        Assert.assertTrue(expr.evaluateBoolean("[0] == 1 && #this[1] == 2 && [2] == 3", array));
        // 访问属性
        Assert.assertTrue(expr.evaluateBoolean("length == 3", array));
    }

    @Test
    public void testCollection() {
        CollectionsObject item = new CollectionsObject();
        item.setKey("key1");
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        item.setMap(map);

        item.setList(Arrays.asList(1,2,3));
        item.setArray(new Integer[]{1,2,3});

        ExpressionEvaluator expr = new ExpressionEvaluator();
        // 这里的key其实是变量不是字符串，变量key对应的值为"key1"
        Assert.assertTrue(expr.evaluateBoolean("map[key] == map['key1']", item));
        Assert.assertTrue(expr.evaluateBoolean("list[0] == 1 ", item));
        Assert.assertTrue(expr.evaluateBoolean("array[1] == 2", item));
    }

    @Test
    public void projection() {
        CollectionsObject object = new CollectionsObject();
        List<TestUser> users = new ArrayList<>();
        users.add(new TestUser("zhangsan", "1", 38));
        users.add(new TestUser("lisi", "2", 10));
        object.setList(users);

        ExpressionEvaluator expr = new ExpressionEvaluator();
        Iterable<?> iterable = expr.evaluateIterable("list.{name}", object);
        // 抽取 TestUser 列表中的 name 属性，形成新的属性
        for (Object o : iterable) {
            System.out.println(o);
        }

        ExpressionEvaluator expr2 = new ExpressionEvaluator();
        // 调用 TestUsers 列表中的每个元素的 sayHello 方法
        System.out.println(expr2.evaluateBoolean("#this.{sayHello()}", users));
    }

    @Test
    public void selection() {
        List<TestUser> users = new ArrayList<>();
        users.add(new TestUser("logan", "1", 11));
        users.add(new TestUser("sam", "2", 10));
        users.add(new TestUser("tom", "3", 10));
        users.add(new TestUser("bob", "4", 10));
        users.add(new TestUser("lily", "5", 11));

        CollectionsObject object = new CollectionsObject();
        object.setList(users);

        ExpressionEvaluator expr = new ExpressionEvaluator();
        Iterable<?> iterable = expr.evaluateIterable("#root.{? #this.age == 10}", users);
        // 筛选年纪为 10 的
        for (Object o : iterable) {
            System.out.println(((TestUser)o).getName());
        }

//        ExpressionEvaluator expr2 = new ExpressionEvaluator();
//        // 调用 TestUsers 列表中选择第一个变量
//        System.out.println(expr2.evaluateBoolean("#var list.{^ #this.age == 10} && var.name == \"sam\"", object));
//        System.out.println(expr2.evaluateBoolean("var.name == \"sam\"", users));
//
//        ExpressionEvaluator expr3 = new ExpressionEvaluator();
//        // 调用 TestUsers 列表中选择第一个变量
//        System.out.println(expr3.evaluateBoolean("#var list.{$ #this.age == 10}", object));
//        System.out.println(expr3.evaluateBoolean("var.name == \"bob\"", users));
    }
}
