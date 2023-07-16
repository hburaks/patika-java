package service;

import model.Brand;
import model.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StoreService {
    public static Store addBrandToStore(Store store, Brand brand){
        if(store.getBrandList() == null){
            store.setBrandList(new ArrayList<>());
        }
        store.getBrandList().add(brand);

    return store;
    }

    public static void printBrandList(Store store){
        if(store.getBrandList() == null){
            store.setBrandList(new ArrayList<>());
        }
        ArrayList<String> brandListNames = new ArrayList<>();
        for(Brand brand :  store.getBrandList()){
          brandListNames.add(brand.getName());
        }
        Collections.sort(brandListNames);
        int i = 1;
        for(String name : brandListNames){
            System.out.println(i + "-" + name);
            i++;
        }
    }
}
