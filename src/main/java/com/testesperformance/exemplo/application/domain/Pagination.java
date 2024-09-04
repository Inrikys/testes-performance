package com.testesperformance.exemplo.application.domain;

public class Pagination {
    private int page;
    private int size;
    private String sortBy;
    private String direction;

    public Pagination(int page, int size, String sortBy, String direction) {
        this.page = page;
        this.size = size;
        this.sortBy = sortBy;
        this.direction = direction;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getDirection() {
        return direction;
    }
}
