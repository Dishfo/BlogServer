package cs.sicnu.fiveg.controller;

import com.google.gson.Gson;
import cs.sicnu.fiveg.dao.CodeLibraryService;
import cs.sicnu.fiveg.pojo.BlogDetails;
import cs.sicnu.fiveg.pojo.CodeLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//todo 记得把字符串常量提取出来
@Controller
@RequestMapping("/code")
public class CodeController {

    @Autowired
    CodeLibraryService codeLibraryService;

    @RequestMapping("/index")
    public String codeIndex(){
        return "code";
    }

    @ResponseBody
    @RequestMapping(value = "/latest" ,produces = "application/json;charset=utf8")
    public String latestCode(){
        List<CodeLibrary> codes=codeLibraryService.queryCodeLibraryPerPage(new CodeLibrary(),
                3,1);
        return new Gson().toJson(codes);
    }

    @ResponseBody
    @RequestMapping(value = "/codenum" )
    public String codenum(){
        int num=codeLibraryService.queryCodeTotalCount(new CodeLibrary());
        return num+"";
    }

    /**
     * @param pageSize
     * @param pageNo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/codecatelog", method = RequestMethod.POST,produces = "application/json;charset=utf8")
    public String codecatelog(int pageSize,int pageNo){
        List<CodeLibrary> list=codeLibraryService.queryCodeLibraryPerPage(new CodeLibrary(),pageSize,pageNo);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/codedata/{codeId}",produces = "application/json;charset=utf8")
    public String codeData(@PathVariable("codeId")Integer id){
        CodeLibrary codeLibrary=codeLibraryService.queryPerCodeById(id);
        return new Gson().toJson(codeLibrary);
    }


    @RequestMapping(value = "/codelib/{codeId}",method = RequestMethod.GET,produces = "application/json;charset=utf8")
    public String codeLibrary(@PathVariable("codeId")Integer id,Model model){
        model.addAttribute("cid",id);
        return "codeLibrary";
    }

    @ResponseBody
    @RequestMapping(value = "/nextcode/{codeId}")
    public String nextCode(@PathVariable("codeId")Integer codeId){
        CodeLibrary codeLibrary=codeLibraryService.queryNextCode(codeId ==null?0: codeId);
        return String.valueOf(codeLibrary==null?0:codeLibrary.getCodeId());
    }

    @ResponseBody
    @RequestMapping(value = "/precode/{codeId}")
    public String preCode(@PathVariable("codeId")Integer codeId){
        CodeLibrary codeLibrary=codeLibraryService.queryPreviousCode(codeId ==null?0: codeId);
        return String.valueOf(codeLibrary==null?0:codeLibrary.getCodeId());
    }


    /**
     *
     * @param newArticle
     * @param articleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    public String addCode(String newArticle,String articleId){
        int res=0;
        if(articleId.equals("false")){
            CodeLibrary codeLibrary=new Gson().fromJson(newArticle,CodeLibrary.class);
            codeLibrary.setCodeDelete(0);
            res=codeLibraryService.insertCodeLibrary(codeLibrary);
        }else {
            CodeLibrary codeLibrary=new Gson().fromJson(newArticle,CodeLibrary.class);
            codeLibrary.setCodeId(Integer.parseInt(articleId));
            res=codeLibraryService.updateCodeById(codeLibrary);
        }
        return res+"";
    }

}
