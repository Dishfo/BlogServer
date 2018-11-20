package cs.sicnu.fiveg.controller;

import com.google.gson.Gson;
import cs.sicnu.fiveg.dao.ReleaseFeatureService;
import cs.sicnu.fiveg.pojo.ReleaseFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/rlsefetr")
public class ReleaseController {

    @Autowired
    ReleaseFeatureService releaseFeatureService;

    //TODO 之后记得把常量提取出来
    @ResponseBody
    @PostMapping(value = "/latest",produces = "application/json;charset=utf8")
    public String lasestFeature(){
        ReleaseFeature releaseFeature=releaseFeatureService.queryLatestReleaseFeature();
        System.out.println(new Gson().toJson(releaseFeature));
        return new Gson().toJson(releaseFeature);
    }
}
