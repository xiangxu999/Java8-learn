package chapter01.task01;

import chapter01.entity.Apple;

/**
 * @Description:苹果重量的筛选
 * @PACKAGE_NAME:chapter01.task01
 * @author:旭日
 * @data:2021/9/24 11:00
 */
public class AppleWeightPredicate implements ApplePredicate
{
    @Override
    public boolean filter(Apple apple)
    {
        return apple.getWeight() > 150;
    }
}
