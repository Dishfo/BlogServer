package cs.sicnu.fiveg.controller;

import com.google.gson.Gson;
import cs.sicnu.fiveg.dao.ArticleCategoryService;
import cs.sicnu.fiveg.pojo.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {


    @Autowired
    ArticleCategoryService articleCategoryService;
    /**
     *
     * @param cclass
     * @return
     */
    @ResponseBody
    @PostMapping (value = "/querycategory",produces = "application/json;charset=utf8")
    public String querycategory(String cclass){
        List<ArticleCategory> categories=articleCategoryService.queryCategory3Num(cclass);
        return new Gson().toJson(categories);
    }

    /**
     *
     * @param cclass
     * @return
     */
    @ResponseBody
    @PostMapping (value = "/queryAllcategory",produces = "application/json;charset=utf8")
    public String queryAllcategory(String cclass){
        List<ArticleCategory> categories=articleCategoryService.queryAllCategory();
        return new Gson().toJson(categories);
    }

    @ResponseBody
    @PostMapping(value = "/addcategory",produces = "application/json;charset=utf8")
    public String addCategory(String cateName){
        ArticleCategory articleCategory=new ArticleCategory();
        articleCategory.setCategoryName(cateName);
        articleCategory.setCategoryDelete(0);
        return articleCategoryService.insertCategory(articleCategory)+"";

    }

}
