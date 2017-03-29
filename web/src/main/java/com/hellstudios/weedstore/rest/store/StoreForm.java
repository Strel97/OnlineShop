package com.hellstudios.weedstore.rest.store;

/**
 * @author strel
 */
public class StoreForm {

    private String name;
    private String description;
    private String ownerId;


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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "ManufacturerForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
