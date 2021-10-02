package chapter02;

import chapter02.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @PACKAGE_NAME:chapter02
 * @author:旭日
 * @data:2021/9/29 10:07
 */
public class Action02
{

    public static void main(String[] args)
    {
        // 筛选出热量高的前三种食物的名字
        List<Dish> dishes = initMenuList();
        List<String> highDishesName = dishes.stream().filter(dish -> dish.getCalories() > 300)
                .limit(3).map(Dish::getName).collect(Collectors.toList());
        highDishesName.forEach(System.out::println);


        System.out.println("-----");
        // List<String> names =
        //         dishes.stream()
        //                 .filter(d -> {
        //                     System.out.println("filtering" + d.getName());
        //                     return d.getCalories() > 300;
        //                 })
        //                 .map(d -> {
        //                     System.out.println("mapping" + d.getName());
        //                     return d.getName();
        //                 })
        //                 .limit(3)
        //                 .collect(Collectors.toList());
        // System.out.println(names);

        // 流的使用包括三件事
        //  一个数据源（如集合）来执行一个查询；
        //  一个中间操作链，形成一条流的流水线；
        //  一个终端操作，执行流水线，并能生成结果。

    }

    public static List<Dish> initMenuList(){
        List<Dish> menuList = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        return menuList;
    }


}
