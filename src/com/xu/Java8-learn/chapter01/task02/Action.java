package chapter01.task02;

import chapter01.entity.Apple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Description:
 * @PACKAGE_NAME:chapter01.task02
 * @author:旭日
 * @data:2021/9/24 19:28
 */
public class Action
{
    private static Filters filters;

    // private static Iterator iterator;

    public static void main(String[] args)
    {
        // 创建一个过滤字符串
        // Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        // List<String> stringList = Arrays.asList("字符串1", "字符串2", "", "字符串3");
        // List<String> result = filters.filter(stringList, nonEmptyStringPredicate);
        // result.forEach(System.out::println);

        // 创建一个通用的遍历器
        // List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        // forEach(
        //         integers,
        //         (Integer i) -> System.out.println(i)
        // );

        // 返回字符串的长度
        // List<Integer> l = map(
        //         Arrays.asList("lambdas","in","action"),
        //         (String s) -> s.length()
        // );
        // l.forEach(System.out::println);


        List<Apple> apples = Arrays.asList(new Apple("red", 150), new Apple("red", 165), new Apple("red", 155),new Apple("green",200));
        // apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        // apples.forEach(System.out::println);


        Predicate<Apple> redApples = apple -> "red".equals(apple.getColor());
        Predicate<Apple> noRedApples = redApples.negate();
        Predicate<Apple> heavyAndRedApples = redApples.and(apple -> apple.getWeight() > 150);
        Predicate<Apple> heavyAndRedOrGreenApples = heavyAndRedApples.or(apple -> "green".equals(apple.getColor()));
        // Stream<Apple> appleStream = apples.stream().filter(redApples);
        Stream<Apple> appleStream = apples.stream().filter(heavyAndRedOrGreenApples);
        appleStream.forEach(System.out::println);


    }

    // 遍历
    public static <T> void forEach(List<T> list, Consumer<T> t){
        for (T i: list){
            t.accept(i);
        }
    }

    //
    public static <T, R> List<R> map(List<T> list,
                                     Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }

}
