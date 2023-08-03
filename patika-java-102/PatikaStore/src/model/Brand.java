package model;

public class Brand {
    private static int lastId = 0;
    private int id;
    private String name;

    public Brand(String name) {
        this.name = name;
        this.id = ++lastId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
