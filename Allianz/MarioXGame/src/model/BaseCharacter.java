package model;

public class BaseCharacter {
    private String name;

    public BaseCharacter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseCharacter{}";
    }
}
