package com.appbusiness.marvelcomics.data.model;

import java.util.List;

/**
 * Created by rrs27 on 2017-12-07.
 */

public class Result {
    private Long id;
    private String title;
    private Thumbnail thumbnail;
    private String description;
    private int pageCount;
    private List<Price> prices;
    private Creators creators;

    public Result(Long id, String title, Thumbnail thumbnail, String description, int pageCount, List<Price> prices, Creators creators) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.description = description;
        this.pageCount = pageCount;
        this.prices = prices;
        this.creators = creators;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Creators getCreators() {
        return creators;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnail=" + thumbnail +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", prices=" + prices +
                ", creators=" + creators +
                '}';
    }
}
