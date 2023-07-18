package service;

import model.Brand;
import model.Category;
import model.Product;
import model.Store;

import java.util.ArrayList;
import java.util.Collections;

public class StoreService {
    public void addBrandToStore(Store store, Brand brand) {
        if (store.getBrandList() == null) {
            store.setBrandList(new ArrayList<>());
        }
        store.getBrandList().add(brand);
    }

    public void addProductToStore(Store store, Product product) {
        if (store.getProductList() == null) {
            store.setProductList(new ArrayList<>());
        }
        store.getProductList().add(product);
    }

    public void addCategoryToStore(Store store, Category category) {
        if (store.getCategoryList() == null) {
            store.setCategoryList(new ArrayList<>());
        }
        store.getCategoryList().add(category);
    }

    public void printBrandList(Store store) {
        if (store.getBrandList() == null) {
            store.setBrandList(new ArrayList<>());
        }
        ArrayList<String> brandListNames = new ArrayList<>();
        for (Brand brand : store.getBrandList()) {
            brandListNames.add(brand.getName());
        }
        Collections.sort(brandListNames);
        int i = 1;
        for (String name : brandListNames) {
            System.out.println(i + "-" + name);
            i++;
        }
    }

    public void printMobilePhoneList(Store store) {
        if (store.getProductList() == null) {
            store.setProductList(new ArrayList<Product>());
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("%-3s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s",
                "ID",
                "Product Name",
                "Brand",
                "Price",
                "Stock",
                "Memory",
                "Screen",
                "RAM",
                "Battery",
                "Color"
        );
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Product product : store.getProductList()) {
            if (product.getCategory().getCategoryId() == 01) {
                System.out.format("%-3d | %-15s | %-10s | %-8s TL | %-10d | %-6.2f GB | %-4.2f inch | %-5.2f RAM | %-8.2f | %-10s",
                        product.getId(),
                        product.getName(),
                        product.getBrand().getName(),
                        product.getUnitPrice(),
                        product.getStockAmount(),
                        product.getMemory(),
                        product.getScreenSize(),
                        product.getRam(),
                        product.getBatteryPower(),
                        product.getColor());

            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public void printComputerList(Store store) {
        if (store.getProductList() == null) {
            store.setProductList(new ArrayList<Product>());
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("%-3s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s",
                "ID",
                "Product Name",
                "Brand",
                "Price",
                "Stock",
                "Memory",
                "Screen",
                "RAM"
        );
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Product product : store.getProductList()) {
            if (product.getCategory().getCategoryId() == 02) {
                System.out.format("%-3d | %-15s | %-10s | %-8s TL | %-10d | %-6.2f GB | %-4.2f inch | %-5.2f RAM",
                        product.getId(),
                        product.getName(),
                        product.getBrand().getName(),
                        product.getUnitPrice(),
                        product.getStockAmount(),
                        product.getMemory(),
                        product.getScreenSize(),
                        product.getRam()
                );

            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public void filterById(Store store, int id) {
        if (store.getProductList() == null) {
            store.setProductList(new ArrayList<Product>());
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("%-3s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s",
                "ID",
                "Product Name",
                "Brand",
                "Price",
                "Stock",
                "Memory",
                "Screen",
                "RAM",
                "Battery",
                "Color"
        );
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Product product : store.getProductList()) {
            if (product.getCategory().getCategoryId() == id) {
                System.out.format("%-3d | %-10s | %-10s | %-8s TL | %-10d | %-6.2f GB | %-4.2f inch | %-5.2f RAM | %-8.2f | %-10s",
                        product.getId(),
                        product.getName(),
                        product.getBrand().getName(),
                        product.getUnitPrice(),
                        product.getStockAmount(),
                        product.getMemory(),
                        product.getScreenSize(),
                        product.getRam(),
                        product.getBatteryPower(),
                        product.getColor());

            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public void filterByBrand(Store store, String brandName) {
        if (store.getProductList() == null) {
            store.setProductList(new ArrayList<Product>());
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("%-3s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s",
                "ID",
                "Product Name",
                "Brand",
                "Price",
                "Stock",
                "Memory",
                "Screen",
                "RAM",
                "Battery",
                "Color"
        );
        System.out.println("here");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Product product : store.getProductList()) {
            if (product.getBrand().getName().toLowerCase() == brandName.toLowerCase()) {
                System.out.format("%-3d | %-10s | %-10s | %-8s TL | %-10d | %-8.2f GB | %-4.2f inch | %-5.2f RAM | %-8.2f | %-10s",
                        product.getId(),
                        product.getName(),
                        product.getBrand().getName(),
                        product.getUnitPrice(),
                        product.getStockAmount(),
                        product.getMemory(),
                        product.getScreenSize(),
                        product.getRam(),
                        product.getBatteryPower(),
                        product.getColor());
                System.out.println("here");
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }
}
