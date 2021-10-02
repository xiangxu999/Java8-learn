package chapter02.entity;

/**
 * @Description:
 * @PACKAGE_NAME:chapter02.entity
 * @author:旭日
 * @data:2021/9/29 9:42
 */
public class People
{
    private String name;

    private char sex;

    private Integer age;

    private String country;

    public People(String name, char sex, Integer age, String country)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.country = country;
    }

    public People(){

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public char getSex()
    {
        return sex;
    }

    public void setSex(char sex)
    {
        this.sex = sex;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}
