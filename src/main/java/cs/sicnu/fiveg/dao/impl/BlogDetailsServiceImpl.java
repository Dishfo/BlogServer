package cs.sicnu.fiveg.dao.impl;

import cs.sicnu.fiveg.dao.BlogDetailsService;
import cs.sicnu.fiveg.mapper.BlogDetailsMapper;
import cs.sicnu.fiveg.pojo.BlogDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class BlogDetailsServiceImpl implements BlogDetailsService {

    @Autowired
    public BlogDetailsMapper blogDetailsMapper;

    @Override
    public List<BlogDetails> queryAllBlogArticles() {
        return blogDetailsMapper.selectAllWithUserInfo();
    }

    @Override
    public int queryBlogTotalCount(BlogDetails details) {
        return blogDetailsMapper.selectBlogCount(details);
    }

    @Override
    public List<BlogDetails> queryBlogArticlePerPage(BlogDetails details, int pageSize, int pageNo) {
        return blogDetailsMapper.selectPaged(details,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public BlogDetails queryPerBlogById(int blogId) {
        BlogDetails details=new BlogDetails();
        details.setBlogId(blogId);
        List<BlogDetails> list=blogDetailsMapper.selectByInfo(details);
        return list.size()==0?null:list.get(0);
    }

    @Override
    public int insertBlogArticle(BlogDetails blogDetails) {
        return  blogDetailsMapper.insert(blogDetails);
    }

    @Override
    public int updateBlogReadById(int blogId) {
        return blogDetailsMapper.updateRead(blogId);
    }

    @Override
    public int updateBlogById(BlogDetails details) {
        return blogDetailsMapper.update(details);
    }

    @Override
    public int logicDeleteBlogById(int blogId) {
        BlogDetails details=new BlogDetails();
        details.setBlogId(blogId);
        details.setBlogDelete(1);
        return blogDetailsMapper.update(details);
    }

    @Override
    public BlogDetails queryPreviousBlog(int blogId) {
        return  blogDetailsMapper.selectPrevBlog(blogId);
    }

    @Override
    public BlogDetails queryNextBlog(int blogId) {
        return blogDetailsMapper.selectNextBlog(blogId);
    }
}
