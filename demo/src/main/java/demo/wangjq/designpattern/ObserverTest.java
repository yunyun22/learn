package demo.wangjq.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjq on 2018/7/16.
 */
public class ObserverTest {


    public static void main(String[] args) {
        List<Observer> observers = new ArrayList<>();
        Observerable observerable = new BeautyGirl(observers);

        Observer o1 = new Boy();
        observerable.registerObserver(o1);
        Observer o2 = new Boy();
        observerable.registerObserver(o2);
        Observer o3 = new Boy();
        observerable.registerObserver(o3);
        Observer o4 = new Boy();
        observerable.registerObserver(o4);

        observerable.notifyObserver("Hello,I am 苍井空.My video start right away");

    }

}

interface Observerable {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver(String message);

}

class BeautyGirl implements Observerable {
    private List<Observer> observers;

    public BeautyGirl(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(String message) {
        observers.forEach(observer -> observer.update(message));

    }
}

interface Observer {
    public void update(String message);
}

class Boy implements Observer {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}