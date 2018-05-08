package learn.wangjq.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
//        Arrays.stream(arrayOfWords).map(word -> word.split("")).flatMap((String[] sss)->Arrays.
// (sss)).distinct().forEach(System.out::print);

        List<Dish> dishList = Arrays.asList(
                new Dish("茄子", true, 100, Dish.Type.OTHER),
                new Dish("猪肉", false, 1000, Dish.Type.MEAT),
                new Dish("鱼", false, 2000, Dish.Type.FISH),
                new Dish("西红柿", true, 2000, Dish.Type.OTHER),
                new Dish("土豆", true, 2000, Dish.Type.OTHER),
                new Dish("上海青", true, 2000, Dish.Type.OTHER),
                new Dish("南瓜", true, 2000, Dish.Type.OTHER),
                new Dish("冬瓜", true, 2000, Dish.Type.OTHER));


        dishList.stream().peek(Dish::getCalories);
//        Map<Dish.Type,List<Dish>> map = dishList.stream().collect(Collectors.groupingBy(Dish::getType));
//
//        System.out.println(map);



//        double avg = dishList.stream().collect(Collectors.averagingInt(Dish::getCalories));
//        System.out.println("avg = " + avg);

//        String menus = dishList.stream().map(Dish::getName).collect(Collectors.joining(",","(",")"));
//        System.out.println("menus = " + menus);
//        IntStream intStream = dishList.stream().mapToInt(Dish::getCalories);
//
//        Stream<Integer> stream =
//                intStream.boxed();
//
//
//        Stream<int[]> stream1 = IntStream.rangeClosed(1, 100).boxed()
//                .flatMap(a ->
//                        IntStream.rangeClosed(a, 100)
//                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
//
//
//        stream1.forEach(t -> System.out.println(t[0]+","+t[1]+","+t[2]));
//        Stream.iterate(new int[]{0, 1}, is -> new int[]{is[1] ,is[0]+is[1]}).limit(10).forEach(t -> {
//            System.out.print(t[0]+","+t[1]+",");
//        });


//        int i = dishList.stream().map(dish -> 1).reduce(0,Integer::sum);
//        System.out.println(i);

//        对比
//        int i = dishList.stream().map(Dish::getCalories).reduce(0, Integer::sum);
//
//        dishList.stream().map(Dish::getCalories).reduce(0, new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return integer + integer2;
//            }
//        });

//        boolean haveVegetaria = dishList.stream().anyMatch(Dish::isVegetarian);
//        System.out.println(haveVegetaria);
//        boolean haveVegetaria = dishList.stream().allMatch(Dish::isVegetarian);
//        System.out.println(haveVegetaria);
//        boolean haveVegetaria = dishList.stream().noneMatch(dish -> dish.getCalories() < 99);
//        System.out.println(haveVegetaria);
//        List<String> names = dishList.stream()
//                .filter(dish -> dish.getCalories() < 1100)
//                .sorted(Comparator.comparing(Dish::getCalories))
//                .map(Dish::getName).collect(Collectors.toList());
//        System.out.println(names);

//        List<Integer> numbers1 = Arrays.asList(1,2,3);
//        List<Integer> numbers2 = Arrays.asList(3,4);
//        Stream<Stream<String>> stringStream = numbers1.stream().map(new Function<Integer, Stream<String>>() {
//            @Override
//            public Stream<String> apply(Integer integer) {
//                return null;
//            }
//        });
//        Stream<int[]> Stream = numbers1.stream().flatMap(new Function<Integer, java.util.stream.Stream<? extends int[]>>() {
//            @Override
//            public Stream<? extends int[]> apply(Integer integer) {
//                return numbers2.stream().map(integer1 -> new int[]{integer,integer1});
//            }
//        });


//        Trader raoul = new Trader("Raoul", "Cambridge");
//        Trader mario = new Trader("Raoul", "Milan");
//        Trader alan = new Trader("Raoul", "Cambridge");
//        Trader brian = new Trader("Raoul", "Cambridge");
//
//        List<Transaction> transactions = Arrays.asList(
//                new Transaction(brian, 2011, 300),
//                new Transaction(raoul, 2012, 1000),
//                new Transaction(raoul, 2011, 400),
//                new Transaction(mario, 2012, 710),
//                new Transaction(mario, 2012, 700),
//                new Transaction(alan, 2012, 950)
//
//        );
//
//        transactions.stream()
//                .filter(transaction -> transaction.getYear() == 2011)
//                .sorted(Comparator.comparing(Transaction::getValue));
//
//        List<String> citys = transactions.stream()
//                .map(transaction -> transaction.getTrader().getCity())
//                .distinct()
//
//                .collect(Collectors.toList());
//
//        List<Trader> traders = transactions.stream().map(transaction -> transaction.getTrader()).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
//
//        boolean haveMilan = transactions.stream().map(Transaction::getTrader).anyMatch(trader -> "".equals(trader.getCity()));
//
//        int totle = transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())).map(Transaction::getValue).reduce(0, (v1, v2) -> v1 + v2);
//
//        Optional<Integer> max = transactions.stream().map(transaction -> transaction.getValue()).max(Integer::compareTo);
//
//        Optional<Integer> min = transactions.stream().map(transaction -> transaction.getValue()).min(Integer::compareTo);

//         Stream.generate(Math::random).limit(100).forEach(System.out::println);


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
        return "{" +
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

class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}


class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}