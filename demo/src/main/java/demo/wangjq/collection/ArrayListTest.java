package demo.wangjq.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjq on 2018/6/29.
 */
public class ArrayListTest {


    public static void main(String[] args) {

//        List<? super Number> list = new ArrayList();
//
//        List<Object> objectList = new ArrayList<>();
//
//
//        printObjet(objectList);
//
//
//        list = objectList;
//
//        System.out.println(list);
//
//
//
//        List<? extends Number> list2 = integerList;
//
//
//        list2.get(0);
//
//
//        Object[] o = new Object[2];
//
//        o[0] = new Integer(1);
//        o[1] = new Object();


        //List<Number> numbers =  new ArrayList<Integer>();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        List<Float> folatList = new ArrayList<>();
        folatList.add(new Float(1.0f));
        List<Long> LongList = new ArrayList<>();
        LongList.add(1L);

        PrintObjet(integerList);
        PrintObjet(folatList);
        PrintObjet(LongList);

        List<Number> list = new ArrayList<>();
        list.add(null);


    }


    public static void printObjet(List<? super Number> list) {

        System.out.println(list);

    }

    public static void PrintObjet(List<? extends Number> list) {

        Number o = list.get(0);

        System.out.println(list.get(0).getClass());
    }

}
