package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductService {
    StoreService storeService = new StoreService();
    private int currentId = 1;
    public Product createMobilPhoneToStore(Store store,
                                    String name,
                                    Brand brand,
                                    BigDecimal unitPrice,
                                    BigDecimal discountRatio,
                                    int stockAmount,
                                    Double ram,
                                    Double memory,
                                    Double screenSize,
                                    Double batteryPower,
                                    ColorTypeEnum color
    ){
        Product product = new Product();
        product.setId(currentId);
        currentId++;
        product.setName(name);
        product.setBrand(brand);
        product.setUnitPrice(unitPrice);
        product.setDiscountRatio(discountRatio);
        product.setStockAmount(stockAmount);
        product.setCategory(findCategoryById(store,01));
        product.setRam(ram);
        product.setMemory(memory);
        product.setScreenSize(screenSize);
        product.setBatteryPower(batteryPower);
        product.setColor(color);
        storeService.addProductToStore(store,product);
        return product;
    }

    public Product createComputerToStore(  Store store,
                                    String name,
                                    Brand brand,
                                    BigDecimal unitPrice,
                                    BigDecimal discountRatio,
                                    int stockAmount,
                                    int categoryId,
                                    Double ram,
                                    Double memory,
                                    Double screenSize
    ){
        Product product = new Product();
        product.setId(currentId);
        currentId++;
        product.setName(name);
        product.setBrand(brand);
        product.setUnitPrice(unitPrice);
        product.setDiscountRatio(discountRatio);
        product.setStockAmount(stockAmount);
        product.setCategory(findCategoryById(store,02));
        product.setRam(ram);
        product.setMemory(memory);
        product.setScreenSize(screenSize);
        storeService.addProductToStore(store,product);
        return product;
    }
    public Category findCategoryById(Store store,int id){
        if(store.getCategoryList() == null){
            store.setCategoryList(new ArrayList<Category>());
        }
        for(Category category : store.getCategoryList()){
            if(category.getCategoryId() == id){
                return category;
            }
        }
        return null;
    }
}
