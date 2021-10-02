package chapter02;

import chapter02.entity.Trader;
import chapter02.entity.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @PACKAGE_NAME:chapter02
 * @author:旭日
 * @data:2021/10/2 9:31
 */
public class Action04
{
    public static void main(String[] args)
    {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 找出2011年的所有交易并按交易额度排序
        System.out.println("找出2011年的所有交易并按交易额度排序");
        List<Transaction> transactionBy2011 = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        transactionBy2011.forEach(System.out::println);
        // 交易员都在哪些不同的城市工作过
        System.out.println("交易员都在哪些不同的城市工作过");
        List<String> collect = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);

        // 查找所有来自于剑桥的交易员，并按姓名排序
        System.out.println("查询所有来自剑桥的交易员，按照姓名排序");
        List<Trader> cambridge = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(cambridge);

        // 返回所有交易员的姓名，按字母顺序排序
        System.out.println("返回所有交易员的姓名，按字母顺序排序");
        List<String> collect1 = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect1);

        // 有没有交易员是在米兰工作的
        long count = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> "Milan".equals(trader.getCity())).count();
        boolean milanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan"));
        System.out.println(count);
        System.out.println(milanBased);

        // 打印生活在剑桥的交易员的所有交易额
        System.out.println("打印生活在剑桥的交易员的所有交易额");
        List<Integer> collect2 = transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        System.out.println(collect2);

        // 所有交易中，最高的交易额是多少
        System.out.println("所有交易中，最高的交易额是多少");
        Optional<Integer> max = transactions.stream().map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(max);

        Optional<Integer> min = transactions.stream().map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(min);

        // 交易求和
        System.out.println("交易求和方式一");
        Integer reduce = transactions.stream().map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(reduce);

        // 映射到数值流
        int sum = transactions.stream().mapToInt(Transaction::getValue)
                .sum();
        System.out.println(sum);




    }


}
