package com.cy.domain;

import java.util.List;

public class Page<T> {
    public static Integer PAGE_SIZE = 4;//限定每页展示4条记录

    private Integer pageNo;//当前页码
    private Integer pageTotal;//总页数
    private Integer pageSize = PAGE_SIZE;//每页可显示的条数
    private Integer PageTotalCount;//总记录数
    private List<T> items;//当前页展示的items
    private String url;//页面的url

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        PageTotalCount = pageTotalCount;
        this.items = items;
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public static void setPageSize(Integer pageSize) {
        PAGE_SIZE = pageSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageTotalCount() {
        return PageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        PageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = 1;
        } else if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", PageTotalCount=" + PageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
