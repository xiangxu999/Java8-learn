package chapter02.entity;

/**
 * @Description:
 * @PACKAGE_NAME:chapter02.entity
 * @author:旭日
 * @data:2021/9/29 10:05
 */
public class Dish
{
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public int getCalories() {
        return calories;
    }
    public Type getType() {
        return type;
    }
    @Override
    public String toString() {
        return name;
    }

    public enum Type { MEAT, FISH, OTHER }

}
