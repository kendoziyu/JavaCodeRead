package org.coderead.mybatis.reflection.methods.bridge;

import java.util.function.Supplier;

/**
 * 描述: 继承 {@link Supplier} 的类 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/17 0017 <br>
 */
public class StringSupplier implements Supplier<String> {

    @Override
    public String get() {
        return "null";
    }
}
