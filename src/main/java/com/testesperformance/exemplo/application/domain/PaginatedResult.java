package com.testesperformance.exemplo.application.domain;

import com.testesperformance.exemplo.adapters.in.web.response.ResultadoPaginadoResponse;

import java.util.List;

public class PaginatedResult<T> {
    private List<T> data;
    private int totalPages;
    private long totalElements;

    public PaginatedResult(List<T> data, int totalPages, long totalElements) {
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