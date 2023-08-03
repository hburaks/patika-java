package service;

import model.Category;
import model.Product;
import model.Store;

import java.util.ArrayList;

public class CategoryService {
    int categoryId = 1;
    public void createCategoryToStore(Store store, String name){
        Category category = new Category();
        category.setCategoryName(name);
        category.setCategoryId(categoryId);
        categoryId++;
        if(store.getCategoryList() == null){
            store.setCategoryList(new ArrayList<Category>());
        }
        store.getCategoryList().add(category);
    }
}
