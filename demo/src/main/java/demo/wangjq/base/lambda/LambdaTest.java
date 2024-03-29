package demo.wangjq.base.lambda;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaTest {
    //List<String> list = new ArrayList<>();
    public static void filter(Support support, String s) {
        if (support.support(s)) {
            System.out.println("s = " + s);
        }
    }

    public static void filterString() {
        Support support = (s1) -> {
            if (s1.length() > 1) {
                return true;
            }
            return false;
        };
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add("" + i);
        }
        for (String s : list) {
            LambdaTest.filter(support, s);
        }


    }

    public static List<Apple> filterAppls(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;

    }


    public static void main(String[] args) {


//        List<Apple> apples = filterAppls(inventory, (apple) -> apple.getWeight() > 150);
//        System.out.println(apples);
//        List<Apple> apples = filterAppls(inventory,apple -> "red".equals(apple.getColor()));
//        System.out.println(apples);
//        inventory.stream().filter(apple -> "red".equals(apple.getColor())).forEach(System.out::println);
//        filterString();
//        System.out.println("sort before:" + inventory);
//        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
//        System.out.println("sort after:" + inventory);
//        如果日没有实现comparable接口会出现ClassCastException
//        inventory.stream().sorted().forEach(System.out::println);
//
//        排序前沒有變化，排序后list也沒有變化。Stream不会改变原有的collection
//        System.out.println("sort before:" + inventory);
//        inventory.stream().sorted((a1, a2) -> a1.getWeight().compareTo(a2.getWeight())).forEach(System.out::println);
//        System.out.println("sort after:" + inventory);
//        将lambda表达式作为一个变量
//        Comparator<Apple> comparable = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
//        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

//        Predicate<Apple> redApple = apple -> "red".equals(apple.getColor());
//        Predicate<Apple> notRedApple = redApple.negate();
//        Predicate<Apple> redAppleAndHeavyApplw = redApple.and(apple -> apple.getWeight() > 150);
//        Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(apple -> apple.getWeight() > 150).or(apple -> "green".equals(apple.getColor()));


        AtomicInteger i = new AtomicInteger();

        List<Long> longs = Arrays.asList(1L, 2L, 3L, 4L);
        Map<Long, Integer> collect1 = longs.stream().collect(Collectors.toMap(Function.identity(), l -> i.getAndIncrement()));

        System.out.println(collect1);


        //数据
        List<Apple> inventory = Arrays.asList(
                new Apple("green", 150),
                new Apple("red", 140),
                new Apple("green", 170));


        Map<String, Apple> collect = inventory.stream().collect(Collectors.groupingBy(
                apple -> apple.getColor() + apple.getWeight(),
                Collector.of(() -> new Apple(null, 0), (o, p) -> {
                    if (o.getColor() == null) {
                        o.setColor(p.getColor());
                    }
                    o.setWeight(o.getWeight() + p.getWeight());
                }, (o, p) -> o)
        ));
        //{red=Apple{color='red', weight=140}, green=Apple{color='green', weight=320}}
        System.out.println(collect);

    }

}

class Apple {
    private String color;
    private Integer weight;

    public Apple() {
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
