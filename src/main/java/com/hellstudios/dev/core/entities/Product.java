package com.hellstudios.dev.core.entities;

/**
 * @author strel
 */
public class Product {

    private String          name;
    private Manufacturer    manufacturer;
    private Store           store;
    private int             price;
    private int             quantity;
    private String          description;


    public Product() {
    }

    public Product(String name, Manufacturer manufacturer, Store store, int price, int quantity, String description) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.store = store;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
