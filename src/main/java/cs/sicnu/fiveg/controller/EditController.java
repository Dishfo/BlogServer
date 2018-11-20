package cs.sicnu.fiveg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditController {

    @RequestMapping(value = "/editor/article.hms")
    public String editorPage(){
        return "editor";
    }


}
