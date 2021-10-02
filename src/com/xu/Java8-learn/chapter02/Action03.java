package chapter02;

import chapter02.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description:
 * @PACKAGE_NAME:chapter02
 * @author:旭日
 * @data:2021/9/29 10:52
 */
public class Action03
{
    public static void main(String[] args)
    {
        // 使用distinct方法筛选各异的元素
        // List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        // numbers.stream()
        //         .filter(i -> i % 2 == 0)
        //         .distinct()
        //         .forEach(System.out::println);

        // 使用limit(n)方法来截短

        // 使用skip(n)方法来扔掉前n个元素


        // 对流中每一个元素应用函数-map
        // List<Dish> dishes = initMenuList();
        // List<String> dishNames = dishes.stream().map(Dish::getName).collect(Collectors.toList());
        // dishNames.forEach(System.out::println);

        // List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        // List<Integer> wordLengths = words.stream()
        //         .map(String::length)
        //         .collect(Collectors.toList());
        // System.out.println(wordLengths);

        // 流的扁平化
        // List<String> words = Arrays.asList("Java8", "Action");
        // System.out.println("没扁平化");
        // List<String[]> collect = words.stream()
        //         .map(word -> word.split(""))
        //         .distinct()
        //         .collect(Collectors.toList());
        // collect.forEach(System.out::println);

        // System.out.println("扁平化");
        // List<String> collect1 = words.stream()
        //         .map(word -> word.split(""))
        //         .flatMap(Arrays::stream)
        //         .distinct()
        //         .collect(Collectors.toList());
        // collect1.forEach(System.out::println);

        // 流的映射练习-返回数组的平方和
        // System.out.println("数组的平方和");
        // List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        // List<Integer> collect = integers.stream()
        //         .map(integer -> integer * integer)
        //         .collect(Collectors.toList());
        // System.out.println(collect);

        // 给定列表[1, 2, 3]和列表[3, 4]，应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。
        // System.out.println("列表的对应");
        // List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        // List<Integer> numbers2 = Arrays.asList(3, 4);
        // List<int[]> pairs =
        //         numbers1.stream()
        //                 .flatMap(i -> numbers2.stream()
        //                         .map(j -> new int[]{i, j})
        //                 )
        //                 .collect(Collectors.toList());
        // pairs.forEach(ints -> System.out.println(Arrays.toString(ints)));


        // 查找和匹配

        // 查找食物中是否有蔬菜
        List<Dish> dishes = initMenuList();
        // 终端操作
        if (dishes.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        // 检查谓词是否匹配所有元素
        boolean b1 = dishes.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(b1);

        // 查找元素 findAny找到一个就断了
        System.out.println("查找一个蔬菜的元素");
        Optional<Dish> any = dishes.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(any);

        // 查找第一个平方和能被3整除的数字
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream()
                .map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findFirst();
        System.out.println(first);

        // 元素求和
        System.out.println("元素求和");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        System.out.println("偶数的求和");
        Integer sumByDouble = list.stream().filter(i -> i % 2 == 0).reduce(0, Integer::sum);
        System.out.println(sumByDouble);

        // 元素之积
        System.out.println("元素之积");
        Integer reduce = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println(reduce);

        // 最大值和最小值
        System.out.println("最大值");
        Optional<Integer> max = list.stream().reduce(Integer::max);
        System.out.println("最小值");
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println("最大值是" + max + "," + "最小值是" + min);




    }

    public static List<Dish> initMenuList()
    {
        List<Dish> menuList = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        return menuList;
    }
}
