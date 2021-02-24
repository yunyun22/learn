package demo.wangjq.base.generic;

/**
 * @author wang, jinqiao
 * @title: Pair
 * @date 27/01/2021
 */
public class Pair<T> {

    private T first;

    private T second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }


    public static void main(String[] args) {
        Pair<Fruit> fruitPair = new Pair<>();
        fruitPair.setFirst(new Fruit());
        Pair<? super Apple> pair =fruitPair;
       // pair.setFirst(new Apple());
        pair.setSecond(new Apple1());
        Object first = pair.getFirst();
        System.out.println(first);

    }
}

class Fruit{}
class Apple extends Fruit{}
class Apple1 extends Apple{}
class Orange extends Fruit{}

