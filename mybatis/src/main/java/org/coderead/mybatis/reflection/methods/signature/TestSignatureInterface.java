package org.coderead.mybatis.reflection.methods.signature;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/15 0015 <br>
 */
public interface TestSignatureInterface {

    void noReturnType(Object param1, Object param2);

    Integer noParameters();

    char getChars(byte[] bytes);

    Object[] getObjectArray(Object... objects);

}
