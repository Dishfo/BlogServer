package cs.sicnu.fiveg.mapper;

import cs.sicnu.fiveg.pojo.ArticleCategory;

import java.util.List;

public interface ArticleCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_category
     *
     * @mbg.generated
     */
    int insert(ArticleCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_category
     *
     * @mbg.generated
     */
    List<ArticleCategory> selectAll();

    int selectMax();


    /**
     * 查询所有种类博客的数目 与相关的信息
     * @return
     */
    List<ArticleCategory> selectCategoryBlogNum();

    /**
     * 查询所有种类code的数目 与相关的信息
     * @return
     */
    List<ArticleCategory> selectCategoryCodeNum();

}