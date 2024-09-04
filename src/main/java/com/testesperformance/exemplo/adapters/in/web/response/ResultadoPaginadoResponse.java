package com.testesperformance.exemplo.adapters.in.web.response;

import java.util.List;

public class ResultadoPaginadoResponse<T> {

    private List<T> data;
    private int totalPages;
    private long totalElements;

    public ResultadoPaginadoResponse(List<T> data, int totalPages, long totalElements) {
        this.data = data;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public List<T> getData() {
        return data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

}
