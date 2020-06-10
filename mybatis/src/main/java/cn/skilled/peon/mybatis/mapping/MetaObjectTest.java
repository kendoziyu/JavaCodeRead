package cn.skilled.peon.mybatis.mapping;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述: 探究 MetaObject 类 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/10 0010 <br>
 */
public class MetaObjectTest {

    private ObjectFactory objectFactory;
    private ObjectWrapperFactory objectWrapperFactory;
    private ReflectorFactory reflectorFactory;

    @Before
    public void init() {
        // 用反射的方式获取构造函数，创建对象
        this.objectFactory = new DefaultObjectFactory();
        this.objectWrapperFactory = new DefaultObjectWrapperFactory();
        this.reflectorFactory = new DefaultReflectorFactory();
    }

    @Test
    public void beanTest() {
        Animal animal = new Animal();
        MetaObject metaObject = MetaObject.forObject(animal, this.objectFactory, this.objectWrapperFactory, this.reflectorFactory);
        // 给 MetaObject 设置键值对，会作用到 animal 对象中
        metaObject.setValue("name", "tiger");
        Assert.assertEquals(animal.getName(), "tiger");
    }

    @Test
    public void collectionTest() {
        Animal animal = new Animal();
        animal.setName("duck");
        List<Animal> list = new ArrayList<>();
        MetaObject metaObject = MetaObject.forObject(list, this.objectFactory, this.objectWrapperFactory, this.reflectorFactory);
        metaObject.add(animal);
        Assert.assertEquals(list.get(0).getName(), "duck");
    }

    @Test
    public void mapTest() {
        Animal animal = new Animal();
        animal.setName("monkey");
        Map<String, Animal> map = new HashMap<>();
        MetaObject metaObject = MetaObject.forObject(map, this.objectFactory, this.objectWrapperFactory, this.reflectorFactory);
        metaObject.setValue("1", animal);
        Assert.assertEquals(map.get("1").getName(), "monkey");
        Assert.assertEquals(metaObject.getValue("1.name"), "monkey");
    }

    @Test
    public void testTokenizer(){
        Animal animal = new Animal();
        animal.setParent(new Animal());
        MetaObject metaObject = MetaObject.forObject(animal, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
        metaObject.setValue("parent.name","tokenizer");
        Assert.assertEquals(animal.getParent().getName(), "tokenizer");
    }

}
