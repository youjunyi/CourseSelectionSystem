package com.fidofi.entity;

import com.fidofi.constant.PageConstant;

/**
 * Created by fido on 2017/12/16.
 * 分页对象
 */
public class Page {
    private Integer currentPage;//当前页
    private Integer pageSize = PageConstant.size;//每页显示的记录数
    private Integer totalPage;//总页数
    private Integer totalCounts;//总记录数
    private Integer startIndex;//在数据库中查询的起始下标
    private String orderRole="desc";//排序规则

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public String getOrderRole() {
        return orderRole;
    }

    public void setOrderRole(String orderRole) {
        this.orderRole = orderRole;
    }

    public Page(Integer currentPage, Integer totalCounts) {
        this.currentPage = currentPage;
        this.totalCounts = totalCounts;
        this.startIndex = (currentPage - 1) * pageSize;
        int pages = totalCounts / pageSize;
        this.totalPage = totalCounts % pageSize == 0 ? pages : pages + 1;
    }

    public Page() {
    }
}
