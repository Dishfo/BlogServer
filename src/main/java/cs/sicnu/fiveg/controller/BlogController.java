package cs.sicnu.fiveg.controller;

import com.google.gson.Gson;
import cs.sicnu.fiveg.dao.BlogDetailsService;
import cs.sicnu.fiveg.pojo.BlogDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

//todo 记得把字符串常量提取出来
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogDetailsService blogDetailsService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String blogIndex(){
        return "blog";
    }

    @ResponseBody
    @RequestMapping(value = "/latest", method = RequestMethod.POST,produces = "application/json;charset=utf8")
    public String latestBlog(){

        List<BlogDetails> blogDetails=
                blogDetailsService.queryBlogArticlePerPage(new BlogDetails(),3,1);
        String str=new Gson().toJson(blogDetails);
        return str;
    }

    @ResponseBody
    @RequestMapping(value = "/blognum", method = RequestMethod.POST,produces = "application/json;charset=utf8")
    public String blognum(){
        int num=blogDetailsService.queryBlogTotalCount(new BlogDetails());
        return num+"";
    }

    /**
     *
     * @param pageSize
     * @param pageNo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/blogcatelog", method = RequestMethod.POST,produces = "application/json;charset=utf8")
    public String blogcatelog(int pageSize,int pageNo){
        List<BlogDetails> list=blogDetailsService.queryBlogArticlePerPage(new BlogDetails(),pageSize,pageNo);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/blogdata/{blogId}",produces = "application/json;charset=utf8")
    public String blogData(@PathVariable("blogId")Integer id){
        BlogDetails blogDetails=blogDetailsService.queryPerBlogById(id);
        return new Gson().toJson(blogDetails);
    }


    @RequestMapping(value = "/blogdet/{blogId}",method = RequestMethod.GET,produces = "application/json;charset=utf8")
    public String blogDetail(@PathVariable("blogId")Integer id,Model model){
        model.addAttribute("bid",id);
        return "blogDetail";
    }

    @ResponseBody
    @RequestMapping(value = "/nextblog/{blogId}")
    public String nextBlog(@PathVariable("blogId")Integer blogId){
        BlogDetails blogDetails=blogDetailsService.queryNextBlog(blogId==null?0:blogId);
        return String.valueOf(blogDetails==null?0:blogDetails.getBlogId());
    }

    @ResponseBody
    @RequestMapping(value = "/preblog/{blogId}")
    public String preBlog(@PathVariable("blogId")Integer blogId){
        BlogDetails blogDetails=blogDetailsService.queryPreviousBlog(blogId==null?0:blogId);
        return String.valueOf(blogDetails==null?0:blogDetails.getBlogId());
    }


    /**
     *
     * @param newArticle
     * @param articleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    public String addBlog(String newArticle,String articleId){
        int res;
        if(articleId.equals("false")){
            BlogDetails blogDetails=new Gson().fromJson(newArticle,BlogDetails.class);
            blogDetails.setBlogDelete(0);
            res=blogDetailsService.insertBlogArticle(blogDetails);
        }else {
            BlogDetails blogDetails=new Gson().fromJson(newArticle,BlogDetails.class);
            blogDetails.setBlogId(Integer.parseInt(articleId));
            res=blogDetailsService.updateBlogById(blogDetails);
        }
        return res+"";
    }

}
