package org.coderead.mybatis.reflection.generic;

import org.coderead.mybatis.reflection.generic.bounds.*;
import org.junit.Test;

public class BoundsTest {

    @Test
    public void upperBoundsTest() {
        Plate<? extends Fruit> fruitPlate = new Plate<Apple>(new Apple());
//        fruitPlate.setItem(new Fruit());
//        fruitPlate.setItem(new Apple());

        Object newFruit1 = fruitPlate.getItem();
        Food newFruit2 = fruitPlate.getItem();
        Fruit newFruit3 = fruitPlate.getItem();
        Apple newFruit4 = (Apple) fruitPlate.getItem();
    }

    @Test
    public void lowerBoundsTest() {
        Plate<? super Fruit> fruitPlate = new Plate<Fruit>(new Apple());
        fruitPlate.setItem(new Fruit());
        fruitPlate.setItem(new Apple());
        fruitPlate.setItem(new GreenApple());

        // 取出来的东西只能放在Object中
        Object newFruit1 = fruitPlate.getItem();
    }
}
