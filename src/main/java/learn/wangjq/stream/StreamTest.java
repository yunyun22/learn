package learn.wangjq.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//        list.stream().filter((s) -> {
//            if (s > 100) {
//                return true;
//            } else {
//                return false;
//            }
//        }).forEach(System.out::println);

//        Stream<String> stream = Stream.of("aaa", "bb", "cc");
//
//        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2);
//        integerStream.limit(10).forEach(System.out::println);
//        integerStream.count();
//
//        Stream.generate(() -> Math.random());


        //过滤，去重
//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,2,3,4,6,7,8,9);
//        numbers.stream().filter(i->i%2==0).distinct().forEach(System.out::println);

        //映射
//        List<String> words = Arrays.asList("Java 8","lambda"," in","Action");
//        words.stream().map(String::length).forEach(System.out::println);
        //流中式数组对象与留中式字符串对象是一个道理
//        String[] arrayOfWords = {"Hello", "world"};
//        Arrays.stream(arrayOfWords).map(word -> word.split("")).forEach(s->System.out.println(s.length));
//        Arrays.stream(arrayOfWords).map(word -> word.split("")).flatMap((String[] sss)->Arrays.stream(sss)).distinct().forEach(System.out::print);

        List<Dish> dishList = Arrays.asList(
                new Dish("茄子", true, 100, Dish.Type.OTHER),
                new Dish("猪肉", false, 1000, Dish.Type.MEAT),
                new Dish("鱼", false, 2000, Dish.Type.MEAT),
                new Dish("非常", false, 2000, Dish.Type.MEAT),
                new Dish("", false, 2000, Dish.Type.MEAT),
                new Dish("牛肉", false, 2000, Dish.Type.MEAT),
                new Dish("牛肉", false, 2000, Dish.Type.MEAT),
                new Dish("牛肉", false, 2000, Dish.Type.MEAT));

        List<String> names = dishList.stream()
                .filter(dish -> dish.getCalories() < 1100)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(Collectors.toList());
//        System.out.println(names);

    }

}

class Dish {
    private final String name;
    private final boolean vegetarian;
    private final Integer calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getCalories() {
        return calories;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public enum Type {
        MEAT, FISH, OTHER
    }
}
