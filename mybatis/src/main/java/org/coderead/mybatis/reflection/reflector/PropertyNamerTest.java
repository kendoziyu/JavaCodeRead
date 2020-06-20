package org.coderead.mybatis.reflection.reflector;

import org.apache.ibatis.reflection.property.PropertyNamer;
import org.junit.Assert;
import org.junit.Test;

/**
 * 描述: {@link org.apache.ibatis.reflection.property.PropertyNamer}  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/18 0018 <br>
 */
public class PropertyNamerTest {

    @Test
    public void test1() {
        System.out.println(PropertyNamer.methodToProperty("getU"));
        System.out.println("u".substring(1).length());
        String str = new String("u".toCharArray(), 1, 0);
        Assert.assertEquals(str, "");
    }
}
