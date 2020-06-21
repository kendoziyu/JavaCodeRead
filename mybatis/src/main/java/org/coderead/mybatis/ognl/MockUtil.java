package org.coderead.mybatis.ognl;

public class MockUtil {

    /**
     * 测试静态方法
     * @return
     */
    public static String mockName(String prefix) {
        String s = System.currentTimeMillis() + "";
        s = s.substring(s.length() - 5);
        return prefix + "_" + s;
    }
}
