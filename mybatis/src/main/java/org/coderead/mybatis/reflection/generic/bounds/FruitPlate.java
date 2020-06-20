package org.coderead.mybatis.reflection.generic.bounds;


public class FruitPlate<T extends Fruit> extends Plate<T> {

    public FruitPlate(T t) {
        super(t);
    }
}
