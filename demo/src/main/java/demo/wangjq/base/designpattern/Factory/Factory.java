package demo.wangjq.base.designpattern.Factory;

/**
 * Created by wangjq on 2018/7/4.
 */
public abstract class Factory {

    public abstract Fruit creatFruit();

}

class AppleFactory extends Factory {

    @Override
    public Fruit creatFruit() {
        return new Apple();
    }
}

class PearFactory extends Factory {

    @Override
    public Fruit creatFruit() {
        return new Pear();
    }
}






