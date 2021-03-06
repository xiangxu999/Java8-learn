package chapter01.entity;

/**
 * @Description:苹果的实体类
 * @PACKAGE_NAME:chapter01.entity
 * @author:旭日
 * @data:2021/9/24 9:58
 */
public class Apple
{
    /**
     * 颜色
     */
    private String color;

    /**
     * 重量
     */
    private Integer weight;

    public Apple () {

    }

    public Apple(String color, Integer weight)
    {
        this.color = color;
        this.weight = weight;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Integer getWeight()
    {
        return weight;
    }

    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
