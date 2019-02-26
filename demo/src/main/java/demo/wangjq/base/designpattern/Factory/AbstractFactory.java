package demo.wangjq.base.designpattern.Factory;

/**
 * Created by wangjq on 2018/7/4.
 */
public abstract class AbstractFactory {
    public abstract Car createCar();

    public abstract Tyre createTyre();
}


class BenzzFactory extends AbstractFactory {
    @Override
    public Car createCar() {
        return null;
    }

    @Override
    public Tyre createTyre() {
        return null;
    }
}


class Car {

}

class Tyre {
}
