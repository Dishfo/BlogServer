package cs.sicnu.fiveg.dao.impl;

import cs.sicnu.fiveg.dao.ArticleCategoryService;
import cs.sicnu.fiveg.mapper.ArticleCategoryMapper;
import cs.sicnu.fiveg.pojo.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Ming []
 * @Date 2018/6/27  10:31
 */
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryMapper categoryMapper;

    @Override
    public int insertCategory(ArticleCategory category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int queryMaxId() {
        return categoryMapper.selectMax();
    }

    @Override
    public List<ArticleCategory> queryCategory3Num(String classification) {
        if(classification.equals("blog")){
            return categoryMapper.selectCategoryBlogNum();
        }else {
            return categoryMapper.selectCategoryCodeNum();
        }
    }

    @Override
    public ArrayList<ArticleCategory> queryAllCategory() {
        return (ArrayList<ArticleCategory>) categoryMapper.selectAll();
    }
}
