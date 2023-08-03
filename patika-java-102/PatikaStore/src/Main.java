import model.Brand;
import model.Category;
import model.ColorTypeEnum;
import model.Store;
import service.CategoryService;
import service.ProductService;
import service.StoreService;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        StoreService storeService = new StoreService();
        CategoryService categoryService = new CategoryService();

        Store store = new Store("Patika Store");

        Brand brand1 = new Brand("Samsung");
        Brand brand2 = new Brand("Lenovo");
        Brand brand3 = new Brand("Apple");
        Brand brand4 = new Brand("Huawei");
        Brand brand5 = new Brand("Casper");
        Brand brand6 = new Brand("Asus");
        Brand brand7 = new Brand("HP");
        Brand brand8 = new Brand("Xiaomi");
        Brand brand9 = new Brand("Monster");

        storeService.addBrandToStore(store, brand1);
        storeService.addBrandToStore(store, brand2);
        storeService.addBrandToStore(store, brand3);
        storeService.addBrandToStore(store, brand4);
        storeService.addBrandToStore(store, brand5);
        storeService.addBrandToStore(store, brand6);
        storeService.addBrandToStore(store, brand7);
        storeService.addBrandToStore(store, brand8);
        storeService.addBrandToStore(store, brand9);

        categoryService.createCategoryToStore(store, "Mobile Phone");
        categoryService.createCategoryToStore(store, "Computer");

        productService.createComputerToStore(store,
                "Matebook 14",
                brand4,
                BigDecimal.valueOf(7000),
                BigDecimal.valueOf(0.7),
                30,
                02,
                16.0,
                512.0,
                14.0
        );

        productService.createMobilPhoneToStore(store,
                "iPhone 11",
                brand3,
                BigDecimal.valueOf(15000),
                BigDecimal.valueOf(0.9),
                12,
                6.0,
                64.0,
                6.1,
                3046.0,
                ColorTypeEnum.BLACK);

        storeService.printBrandList(store);
        storeService.printComputerList(store);
        storeService.printMobilePhoneList(store);

        storeService.filterById(store, 01);
        storeService.filterByBrand(store, "Huawei");
    }
}