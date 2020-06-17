package org.coderead.mybatis.reflection.methods.bridge;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/16 0016 <br>
 */
public class StringFactory extends GenericFactory<String> {

    public String createOne() {
        return "";
    }

    /**
     * 使用了和父类相同的函数名称 {@link GenericFactory#changeFrom(Object)}, 但是修改了参数类型，
     * 此时相当于子类创建了一个新的参数
     * @param src
     * @return
     */
    public Object changeFrom(String src) {
        return "StringFactory";
    }

    @Override
    public String create() {
        return "";
    }

    public Object product() {
        return "string";
    }

    public static String convert(String t) {
        return t;
    }

    public static String staticMethod() {
        return "ss";
    }
}
