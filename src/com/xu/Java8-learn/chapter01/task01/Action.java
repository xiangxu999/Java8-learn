package chapter01.task01;

import chapter01.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @PACKAGE_NAME:chapter01
 * @author:旭日
 * @data:2021/9/24 9:41
 */
public class Action
{

    public static void main(String[] args)
    {
        List<Apple> appleList = initApples();
        Task task01 = new Task();
        // 任务1-筛选绿苹果
        // List<Apple> result = task01.filterGreenApples(appleList);
        // result.forEach(System.out::println);

        // 任务1-通过颜色来筛选苹果
        // List<Apple> result = task01.filterApplesByColor(appleList, "red");
        // result.forEach(System.out::println);

        // 任务1-通过重量来筛选苹果
        // List<Apple> result = task01.filterApplesByWeight(appleList, 150);
        // result.forEach(System.out::println);

        // 刚才我们这种完成需求的方式有一个问题，如果后面需要筛选的属性越来越多，我们只能在代码中不断添加属性

        // 接下来我们尝试用接口的方式来完成行为的参数化
        // 重量
        // List<Apple> result1 = task01.filterApples(appleList, new AppleWeightPredicate());
        // result1.forEach(System.out::println);

        // 颜色
        // List<Apple> result2 = task01.filterApples(appleList, new AppleGreenColorPredicate());
        // result2.forEach(System.out::println);

        // 同理如果我们需要两个属性，只需要额外写一个类实现ApplePredicate即可
        // List<Apple> result3 = task01.filterApples(appleList, new AppleRedAndHeavyPredicate());
        // result3.forEach(System.out::println);

        // 匿名的方式
        // List<Apple> result = task01.filterApples(appleList, new ApplePredicate() {
        //     @Override
        //     public boolean filter(Apple apple)
        //     {
        //         return "red".equals(apple.getColor());
        //     }
        // });
        // result.forEach(System.out::println);

        // Lambda 表达式(这里相当于new ApplePredicate()我用Lambda来代替了)
        // List<Apple> result = task01.filterApples(appleList, (Apple apple) -> "red".equals(apple.getColor()));
        // result.forEach(System.out::println);

        // 现在如果我们不仅要苹果进行筛选，我们其他的还需要筛选，那我们就需要一个抽象化的方法
        // List<Apple> redApples = task01.filter(appleList, (Apple apple) -> "red".equals(apple.getColor()));
        // redApples.forEach(System.out::println);

        // List<Integer> integers = initNumbers();
        // 筛选偶数
        // List<Integer> filter = task01.filter(integers, (Integer number) -> number % 2 == 0);
        // filter.forEach(System.out::println);

        // 筛选大于2的数
        // List<Integer> filter1 = task01.filter(integers, (Integer number) -> number > 2);
        // filter1.forEach(System.out::println);

        List<Apple> apples = initApples();
        // apples.sort(new Comparator<Apple>()
        // {
        //     @Override
        //     public int compare(Apple a1, Apple a2)
        //     {
        //         return a1.getWeight().compareTo(a2.getWeight());
        //     }
        // });
        // apples.forEach(System.out::println);
        apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        apples.forEach(System.out::println);

    }

    /**
     * 初始化3个苹果
     *
     * @return
     */
    public static List<Apple> initApples()
    {
        List<Apple> inventory = Arrays.asList(new Apple("green", 150),
                new Apple("yellow", 160),
                new Apple("red", 140),
                new Apple("red", 160));
        return inventory;
    }

    /**
     * 初始化一个数字数组
     * @return
     */
    public static List<Integer> initNumbers()
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        return list;
    }


}
