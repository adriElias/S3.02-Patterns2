package ProgressiveInterface;

public class Dish {
    private String type;
    private String name;
    private boolean isVegan = false;
    private boolean isGlutenFree = false;



    public Dish(String type, String name) {
        this.type = type;
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("The dish name cannot be empty.");
        this.name = name;

    }

    @Override
    public String toString() {
        return "Dish{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", isVegan=" + isVegan +
                ", isGlutenFree=" + isGlutenFree +
                '}';
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean getIsVegan() {
        return isVegan;
    }

    public void setIsVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean getIsGlutenFree() {
        return isGlutenFree;
    }

    public void setIsGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }
}
