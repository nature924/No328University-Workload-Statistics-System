package com.hdc.entity;

public class Page {
    private String field;
    private String order;
    private Integer page;
    private Integer limit;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void init() {
        this.page = 1;
        this.limit = 15;
    }

    public Page() {

    }

    public Page(String field, String order, Integer page, Integer limit) {
        this.field = field;
        this.order = order;
        this.page = page;
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Page{" +
                "field='" + field + '\'' +
                ", order='" + order + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }
}
