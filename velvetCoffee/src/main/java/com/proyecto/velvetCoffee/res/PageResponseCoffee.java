package com.proyecto.velvetCoffee.res;

import com.proyecto.velvetCoffee.model.Coffee;
import java.util.List;

public class PageResponseCoffee {
    private List<Coffee> content;
    private int totalElements;
    private int totalPages;
    private int currentPage;

    public PageResponseCoffee(List<Coffee> content, int totalElements, int totalPages, int currentPage) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    // Getters and Setters
    public List<Coffee> getContent() {
        return content;
    }

    public void setContent(List<Coffee> content) {
        this.content = content;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
