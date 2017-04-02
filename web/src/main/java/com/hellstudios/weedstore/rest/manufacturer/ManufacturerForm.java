package com.hellstudios.weedstore.rest.manufacturer;

/**
 * @author strel
 */
public class ManufacturerForm {

    private String name;
    private String description;
    private String originCountry;
    private String image;
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

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ManufacturerForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", image='" + image + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
