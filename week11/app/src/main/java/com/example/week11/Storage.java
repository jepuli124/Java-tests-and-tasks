package com.example.week11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Storage {
    private ArrayList<Product> products = new ArrayList<Product>();
    private static Storage storage = null;

    private Storage() {
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Product> getStarredProducts() {
        ArrayList<Product> starredProducts = new ArrayList<>();
        for(Product product: products){
            if(product.isStar()){
                starredProducts.add(product);
            }
        }
        return starredProducts;
    }

    public Product getProduct(int id){
        return products.get(id);
    }

    public void addProduct(Product product) {
        product.setId(products.size()+1);
        products.add(product);
    }

    public void delProduct(int id){
        products.remove(id);
    }

    public void sortId(){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product product2) {
                return product.getId() - product2.getId();
            }
        });
    }

    public void sortAlpha(){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product product2) {
                return product.getText().compareToIgnoreCase(product2.getText());
            }
        });
    }

}
