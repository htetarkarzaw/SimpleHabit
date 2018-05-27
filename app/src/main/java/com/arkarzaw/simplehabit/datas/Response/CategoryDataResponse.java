package com.arkarzaw.simplehabit.datas.Response;

import com.arkarzaw.simplehabit.datas.VO.CategoryVO;

import java.util.List;

public class CategoryDataResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<CategoryVO> categoriesPrograms;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<CategoryVO> getCategoriesPrograms() {
        return categoriesPrograms;
    }
}
