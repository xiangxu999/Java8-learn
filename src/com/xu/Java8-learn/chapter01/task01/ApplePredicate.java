package chapter01.task01;

import chapter01.entity.Apple;

/**
 * @Description:苹果的筛选接口
 * @PACKAGE_NAME:chapter01.task01
 * @author:旭日
 * @data:2021/9/24 10:59
 */
public interface ApplePredicate
{
    boolean filter (Apple apple);
}
