package com.example.library_x;

public class Datamodel {

    private String itemText,duedate,publishdate;
    String image;
    private boolean isExpandable;


    public Datamodel(String duedate,String publishdate,String image, String itemText) {
        this.duedate = duedate;
        this.publishdate = publishdate;
        this.image = image;
        this.itemText = itemText;
        isExpandable = false;
    }

    public String getImage() {
        return image;
    }

    public String getItemText() {
        return itemText;
    }

    public String getDuedate() {
        return duedate;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }


}
