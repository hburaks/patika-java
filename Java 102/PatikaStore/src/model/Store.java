package model;

import java.util.ArrayList;

public class Store {
    private String name;
    private ArrayList<Brand> brandList;

    public Store(String name, ArrayList<Brand> brandList) {
        this.name = name;
        this.brandList = brandList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(ArrayList brandList) {
        this.brandList = brandList;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", brandList=" + brandList +
                '}';
    }
}
