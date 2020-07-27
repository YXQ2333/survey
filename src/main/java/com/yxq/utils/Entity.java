package com.yxq.utils;

import java.io.Serializable;

/**
 * 实现分页
 *
 * @author yxq
 * @date 2020/7/26 22:21
 */
public class Entity implements Serializable {
    private Integer page;   //
    private Integer limit;  //

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
}
