package chapter02.entity;

/**
 * @Description:
 * @PACKAGE_NAME:chapter02.entity
 * @author:旭日
 * @data:2021/10/2 9:30
 */
public class Trader
{
    private final String name;
    private final String city;

    public Trader(String n, String c)
    {
        this.name = n;
        this.city = c;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCity()
    {
        return this.city;
    }

    public String toString()
    {
        return "Trader:" + this.name + " in " + this.city;
    }
}
