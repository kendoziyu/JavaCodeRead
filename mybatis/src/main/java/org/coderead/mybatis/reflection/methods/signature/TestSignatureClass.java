package org.coderead.mybatis.reflection.methods.signature;

import org.apache.ibatis.reflection.Reflector;

import java.util.Collection;
import java.util.List;

/**
 * 描述: 用来测试
 * {@see org.apache.ibatis.reflection.Reflector#getSignature(Method)} 的签名  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/15 0015 <br>
 */
public class TestSignatureClass {

    public void noReturnType(Object param1, Object param2) {}

    public Integer noParameters() {return null;}

    public static void main(String[] args) {

    }

    List returnList() {return null;}

    Collection<Integer> returnIntegerCollection() {return null;}
}
