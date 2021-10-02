package chapter02;

import chapter02.entity.People;
import javafx.scene.Group;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @PACKAGE_NAME:chapter02
 * @author:旭日
 * @data:2021/9/29 9:43
 */
public class Action01
{
    public static void main(String[] args)
    {
        List<People> peopleList = Arrays.asList(new People("张三", '男', 15, "中国"),
                new People("李四", '女', 18, "中国"),
                new People("老五", '男', 30, "美国"));

        // 选择年龄是20以下的，按照姓名排序，获取国家名称
        List<String> collect = peopleList.parallelStream().filter(people -> people.getAge() < 20)
                .sorted(Comparator.comparing(People::getName))
                .map(People::getCountry).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
