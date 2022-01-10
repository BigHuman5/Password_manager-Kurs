package com.example.Password_manager;

import com.example.Password_manager.model.Category;

import java.util.ArrayList;
import java.util.List;

public class StringsProject {

    private String[] categoryFilterTitle;
    private String[] nameWebSites;

    public void definitionStrings()
    {
        categoryFilterTitle=new String[]{
                "Веб-сайты",
                "Банковские карты",
                "Прочее",
                "Веб-сайты",
                "Банковские карты",
                "Прочее"
        };

    }

    public List<Category> getListCategoryFilterTitle()
    {
        definitionStrings();
        List<Category> categoryList = new ArrayList<>();
        for(int i=0;i<categoryFilterTitle.length;i++)
            categoryList.add(new Category(i,categoryFilterTitle[i]));
        return categoryList;
    }
    public String[] getCategoryFilterTitle() {
        return categoryFilterTitle;
    }

    public void setCategoryFilterTitle(String[] categoryFilterTitle) {
        this.categoryFilterTitle = categoryFilterTitle;
    }

}
