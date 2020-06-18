package org.coderead.mybatis.reflection.methods.bridge;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/17 0017 <br>
 */
public class IntegerConsumer extends BaseConsumer {

    public void accept(Integer integer) {
        System.out.println("consumed " + integer);
    }
}
