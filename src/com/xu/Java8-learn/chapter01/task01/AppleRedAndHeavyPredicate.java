package chapter01.task01;

import chapter01.entity.Apple;

/**
 * @Description:
 * @PACKAGE_NAME:chapter01.task01
 * @author:旭日
 * @data:2021/9/24 15:29
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate
{
    @Override
    public boolean filter(Apple apple)
    {
        return "red".equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
