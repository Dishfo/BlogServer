package cs.sicnu.fiveg.dao;

import cs.sicnu.fiveg.pojo.BlogDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客文章接口
 *
 * @author 石旭辉
 * <p>
 * 2017年9月17日
 */

public interface BlogDetailsService {
    /**
     * 查询博客文章
     *
     * @return 博客文章数组
     */
    List<BlogDetails> queryAllBlogArticles();

    /**
     * 根据条件询博客数量
     *
     * @param details
     * @return
     */
    int queryBlogTotalCount(BlogDetails details);

    /**
     * 按照页面大小和页码查询博客
     *
     * @param details
     * @param pageSize
     * @param pageNo
     * @return
     */
    List<BlogDetails> queryBlogArticlePerPage(BlogDetails details, int pageSize, int pageNo);

    /**
     * 根据id查询单独的一篇博客
     *
     * @param blogId
     * @return 一篇博客
     */
    BlogDetails queryPerBlogById(int blogId);

    /**
     * 插入记录
     *
     * @param blogDetails
     * @return 返回插入结果
     */
    int insertBlogArticle(BlogDetails blogDetails);

    /**
     * 根据id更新博客阅读次数
     *
     * @param blogId
     * @return
     */
    int updateBlogReadById(int blogId);

    /**
     * 根据id修改博客内容
     *
     * @param details
     * @return
     */
    public int updateBlogById(BlogDetails details);

    /**
     * 根据id逻辑删除博客
     *
     * @param blogId
     * @return
     */
    int logicDeleteBlogById(int blogId);

    /**
     * 根据id查找上一篇有效博客
     *
     * @param blogId
     * @return
     */
    BlogDetails queryPreviousBlog(int blogId);

    /**
     * 根据id查找下一篇有效博客
     *
     * @param blogId
     * @return
     */
    BlogDetails queryNextBlog(int blogId);
}