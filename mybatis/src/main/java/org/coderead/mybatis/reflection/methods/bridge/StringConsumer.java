package org.coderead.mybatis.reflection.methods.bridge;

import java.util.function.Consumer;

/**
 * 描述:  泛型消费<br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/17 0017 <br>
 */
public class StringConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println("i consumed " + s);
    }
}
