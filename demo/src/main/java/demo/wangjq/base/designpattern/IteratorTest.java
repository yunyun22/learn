package demo.wangjq.base.designpattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * it is my iterator
 * Created by wangjq on 2018/7/13.
 */
public class IteratorTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");


        Iterator<String> iterator = new ConcreteIterator<>(list);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class ConcreteIterator<T> implements Iterator {

    private List<T> list;

    private int index;

    public ConcreteIterator(List<T> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        if (list.size() > index) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Object o = list.get(index);
        index++;
        return o;

    }
}

