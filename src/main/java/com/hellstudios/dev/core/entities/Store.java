package com.hellstudios.dev.core.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author strel
 */
public class Store {

    private int             id;
    private String          name;
    private String          description;
    private List<Product>   products;
    private Manufacturer    manufacturer;


    public Store() {
    }

    public Store(String name, String description, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.products = new ArrayList<Product>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
