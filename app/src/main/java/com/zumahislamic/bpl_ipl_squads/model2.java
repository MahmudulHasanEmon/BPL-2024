package com.zumahislamic.bpl_ipl_squads;

public class model2 {
    String name, image, category, country;

    public model2(String name, String image, String category, String country) {
        this.name = name;
        this.image = image;
        this.category = category;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
