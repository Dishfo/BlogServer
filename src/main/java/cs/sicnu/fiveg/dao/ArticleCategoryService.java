package cs.sicnu.fiveg.dao;

import cs.sicnu.fiveg.pojo.ArticleCategory;

import java.util.List;

public interface ArticleCategoryService {

    /**
     * 插入新的分类
     * @param category
     * @return
     */
    public int insertCategory(ArticleCategory category);

    /**
     * 查询当前最大id
     * @return
     */
    public int queryMaxId();

    /**
     * 根据文章类别查询分类和相应的数量
     * @param classification
     * @return
     */
    public List<ArticleCategory> queryCategory3Num(String classification);

    /**
     * 查询所有分类
     * @return
     */
    public List<ArticleCategory> queryAllCategory();



}
