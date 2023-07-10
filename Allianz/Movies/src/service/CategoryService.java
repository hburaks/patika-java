package service;

import model.Category;

import java.util.ArrayList;

public class CategoryService {
    public static ArrayList<Category> createDefaultCategories(){
        ArrayList<Category> categories = new ArrayList<>();

        Category comedy = new Category("Komedi");
        Category horror = new Category("Korku");
        Category adventure = new Category("Macera");
        Category scienceFiction = new Category("Bilim-Kurgu");
        Category drama = new Category("Dram");

        return categories;
    }
}
