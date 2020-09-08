package com.developer.chp.yourcaption;

import java.util.List;

public class Captions {

    String caption;
    String Author;


    public Captions() {
    }


    public Captions(String caption, String author) {
        this.caption = caption;
        Author = author;
    }

    @Override
    public String toString() {
        return "Captions{" +
                "caption='" + caption + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }


}