package model;

public class Branch {

    private String name;

    public Branch(){}
    public Branch(String name) {
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
        return  "Branş İsmi= " + name;
    }
}
