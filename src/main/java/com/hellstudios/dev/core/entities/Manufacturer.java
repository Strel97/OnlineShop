package com.hellstudios.dev.core.entities;

import java.util.Set;

/**
 * @author strel
 */
public class Manufacturer {

    private String      name;
    private String      description;
    private String      originCountry;
    private Set<Store>  stores;


    public Manufacturer() {
    }

    public Manufacturer(String name, String description, String originCountry) {
        this.name = name;
        this.description = description;
        this.originCountry = originCountry;
    }

    public Manufacturer(String name, String description, String originCountry, Set<Store> stores) {
        this.name = name;
        this.description = description;
        this.originCountry = originCountry;
        this.stores = stores;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void addStore(Store store) {
        if (store == null)
            return;

        stores.add( store );
    }
}
