import model.Brand;
import model.Store;
import service.StoreService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Brand brand1 = new Brand("Samsung");
        Brand brand2 = new Brand("Lenovo");
        Brand brand3 = new Brand("Apple");
        Brand brand4 = new Brand("Huawei");
        Brand brand5 = new Brand("Casper");
        Brand brand6 = new Brand("Asus");
        Brand brand7 = new Brand("HP");
        Brand brand8 = new Brand("Xiaomi");
        Brand brand9 = new Brand("Monster");

        ArrayList<Brand> brandList = new ArrayList<>();
        brandList.add(brand1);
        brandList.add(brand2);
        brandList.add(brand3);
        brandList.add(brand4);
        brandList.add(brand5);
        brandList.add(brand6);
        brandList.add(brand7);
        brandList.add(brand8);
        brandList.add(brand9);

        Store store = new Store("Patika Store", brandList);
        store.setBrandList(brandList);
        StoreService.printBrandList(store);
    }
}