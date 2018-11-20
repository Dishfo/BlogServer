package cs.sicnu.fiveg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/download")
public class DownloadController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String downloadIndex(){
        return "download";
    }

}
