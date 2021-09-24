package chapter01.task01;

import chapter01.entity.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @PACKAGE_NAME:chapter01.task
 * @author:旭日
 * @data:2021/9/24 10:15
 */
public class Task
{
    /**
     * 筛选绿苹果
     *
     * @param inventory
     * @return
     */
    public List<Apple> filterGreenApples(List<Apple> inventory)
    {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选苹果-颜色作为参数
     *
     * @param inventory
     * @param color
     * @return
     */
    public List<Apple> filterApplesByColor(List<Apple> inventory, String color)
    {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选苹果-重量作为参数
     *
     * @param inventory
     * @param weight
     * @return
     */
    public List<Apple> filterApplesByWeight(List<Apple> inventory, int weight)
    {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByWeightAndColor(List<Apple> inventory, int weight, String color)
    {
        // 相关的代码
        return null;
    }

    /**
     * 过滤的通用方法
     *
     * @param inventory
     * @param p
     * @return
     */
    public List<Apple> filterApples(List<Apple> inventory, ApplePredicate p)
    {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.filter(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public <T> List<T> filter(List<T> list, Predicate<T> p)
    {
        List<T> result = new ArrayList<>();
        for(T t : list)
        {
            if(p.filter(t)){
                result.add(t);
            }
        }
        return result;
    }


}
