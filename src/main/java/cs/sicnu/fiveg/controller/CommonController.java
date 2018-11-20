package cs.sicnu.fiveg.controller;

import com.google.gson.JsonObject;
import cs.sicnu.fiveg.context.OnLineCountListener;
import cs.sicnu.fiveg.dao.VisitTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    public VisitTotalService visitTotalService;

    //TODO 提取出字符串常量
    @ResponseBody
    @RequestMapping(value = "/accessAtatistics",method = RequestMethod.POST)
    public String accessAtatistics(){
        JsonObject obj1=new JsonObject();
        obj1.addProperty("accessToday",visitTotalService.queryVisitToday());
        obj1.addProperty("accessTotal",visitTotalService.queryVisitTotal());
        obj1.addProperty("onlineCurrent",OnLineCountListener.getOnLineCount());
        return obj1.toString();
    }
}
