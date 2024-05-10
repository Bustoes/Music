package com.web.group.common.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.web.group.common.page.PageResponse;

import java.util.List;

public class PageUtil {

    public static void startPage(int currPage, int pageSize) {
        PageHelper.startPage(currPage <= 0 ? 1 : currPage, pageSize <= 0 ? 10 : pageSize);
    }

    public static <T> PageResponse<T> convertPageData(List<T> list) {
        PageResponse<T> pageResponse = new PageResponse<>();
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            pageResponse.setList(page.getResult());
            pageResponse.setTotalCount(page.getTotal());
            pageResponse.setCurrPage(page.getPageNum());
            pageResponse.setPageSize(page.getPageSize());
        }
        return pageResponse;
    }

}
