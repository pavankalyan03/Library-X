package com.example.library_x;

public class Datamodel {

    private String details, itemText;
    String image;
    private boolean isExpandable;


    public Datamodel(String details,String image, String itemText) {
        this.details = details;
        this.image = image;
        this.itemText = itemText;
        isExpandable = false;
    }

    public String getDetails() {
        return details;
    }

    public String getImage() {
        return image;
    }

    public String getItemText() {
        return itemText;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }


}
