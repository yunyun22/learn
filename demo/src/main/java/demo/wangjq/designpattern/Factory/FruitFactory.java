package demo.wangjq.designpattern.Factory;

/**
 * 简单的工厂模式
 * Created by wangjq on 2018/7/4.
 */
public class FruitFactory {

    public static Fruit creatFruit(String type) {

        if ("Apple".equals(type)) {
            return new Apple();
        }
        if ("Pear".equals(type)) {
            return new Pear();
        }
        return null;
    }

}

interface Fruit {

}

class Apple implements Fruit {

}

class Pear implements Fruit {

}