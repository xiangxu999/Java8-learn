package chapter01.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description:
 * @PACKAGE_NAME:chapter01.task02
 * @author:旭日
 * @data:2021/9/24 19:51
 */
public class Filters
{
    /**
     * 通用过滤方法
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T t : list) {
            if(p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
