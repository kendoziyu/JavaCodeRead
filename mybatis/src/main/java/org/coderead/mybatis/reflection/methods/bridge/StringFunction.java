package org.coderead.mybatis.reflection.methods.bridge;

import java.util.function.Function;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/17 0017 <br>
 */
public class StringFunction implements Function<String, String> {

    @Override
    public String apply(String s) {
        return s + " , hello";
    }

    public static void main(String[] args) {
        Function func = new StringFunction();
        System.out.println(func.apply(new Object()));
    }
}
