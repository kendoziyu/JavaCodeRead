package org.coderead.mybatis.reflection.methods.bridge;

import org.junit.Test;

/**
 * 描述: 桥接方法测试 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/17 0017 <br>
 */
public class BridgeMethodsTest {

    @Test
    public void test1() {
        StringConsumer c = new StringConsumer();
        c.accept("fries");
    }
}
