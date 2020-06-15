package org.coderead.mybatis.reflection.methods.signature;

import java.lang.reflect.Method;

/**
 * 描述: 常见的 {@link Method#getReturnType()} <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/15 0015 <br>
 */
public interface ReturnTypes {

    Void returnTheVoid();

    void returnVoid();

    Object returnObject();

    Object[] returnObjects();

    Object[][] returnObjectss();

    Object[][][] returnObjectsss();

    String[] returnStrings();
    /**
     * 基本类型
     * @return
     */
    byte returnByte();

    char returnChar();

    short returnShort();

    int returnInt();

    long returnLong();

    float returnFloat();

    double returnDouble();

    boolean returnBoolean();

    /**
     * 包装类
     */
    Byte returnTheByte();

    Character returnTheChar();

    Short returnTheShort();

    Integer returnTheInt();

    Long returnTheLong();

    Float returnTheFloat();

    Double returnTheDouble();

    Boolean returnTheBoolean();

    /**
     * 基本类型数组
     */
    byte[] returnBytes();

    char[] returnChars();

    short[] returnShorts();

    int[] returnInts();

    long[] returnLongs();

    float[] returnFloats();

    double[] returnDoubles();

    boolean[] returnBooleans();

    /**
     * 返回包装类数组
     * @return
     */
    Byte[] returnTheBytes();

    Character[] returnTheChars();

    Short[] returnTheShorts();

    Integer[] returnTheInts();

    Long[] returnTheLongs();

    Float[] returnTheFloats();

    Double[] returnTheDoubles();

    Boolean[] returnTheBooleans();

    interface inner {
        void hello();
    }
}
