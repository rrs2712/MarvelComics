package com.appbusiness.marvelcomics.data.model;

/**
 * Created by rrs27 on 2017-12-05.
 */

public class Detail {

    private String title;
    private String description;
    private String pageCount;
    private String price;
    private String authors;

    public Detail(String title, String description, String pageCount, String price, String authors) {
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.price = price;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", price='" + price + '\'' +
                ", authors='" + authors + '\'' +
                '}';
    }
}
