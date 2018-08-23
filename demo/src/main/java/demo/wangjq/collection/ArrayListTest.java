package demo.wangjq.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjq on 2018/6/29.
 */
public class ArrayListTest {


    public static void main(String[] args) {

        List<? super Number> listObjects = new ArrayList();

        List<Number> objectsList = new ArrayList<>();


        objectsList.add(1);

        printObjet(objectsList);
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

        List<String> stringList = null;
        List<Object> objectList = null;

        //objectList = stringList;

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


        List<? super Number> nlist = new ArrayList<>();

        //List<?>

        /**
         * 在泛型里面，泛型是具备继承的。  List<String> List<Object>没有继承关系。
         * 如果需要模板方法对入参（泛型）做多态来封装，需要用到类型通配符。
         * 例如：List<Integer> List<Float>  List<Long> 需要写个通用的方法将list遍历。
         * 这时候的入参为：List<? extends Number> list
         */
        //List<? super Number>  = List<?>  super List<Number>
        //List<? extends Number>  = List<?>  extends List<Number>


        nlist.add(new Integer(1));
        Number number = new Integer(1);


        System.out.println("getclass==========" + number.getClass());

        nlist.add(number);

    }


    public static void printObjet(List<? super Number> list) {

        Object object = list.get(0);


        list.add(1);
        System.out.println(list);

    }

    public static void PrintObjet(List<? extends Number> list) {

        Number o = list.get(0);

        //list.add(1);
        System.out.println(list.get(0).getClass());
    }

}
