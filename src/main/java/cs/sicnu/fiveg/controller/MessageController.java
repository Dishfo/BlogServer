package cs.sicnu.fiveg.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import cs.sicnu.fiveg.dao.MessageAreaService;
import cs.sicnu.fiveg.pojo.MessageArea;
import cs.sicnu.fiveg.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {


    @Autowired
    MessageAreaService messageAreaService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String messageIndex(){
        return "message";
    }

    /**
     *
     * @param messageId belongid 用处暂时不明
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/messagelist",method = RequestMethod.POST,produces = "application/json;charset=utf8")
    public String messagelist(int messageId){
        List<MessageArea> list= messageAreaService.queryAllMessageArea(messageId);
        return new Gson().toJson(list);
    }


    /**
     *
     * @param newMessage
     * @return
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @ResponseBody
    @RequestMapping(value = "/addmessage" ,method = RequestMethod.POST,produces = "application/json;charset=utf8")
    public String addMessage(String newMessage){
        JsonObject jsonObject=new JsonObject();
        try {
            MessageArea messageArea=new Gson().fromJson(newMessage,MessageArea.class);
            System.out.println(newMessage);
            int res = messageAreaService.insertMessageNew(messageArea);
            if (res > 0) {
                jsonObject.addProperty("result", 1);
                jsonObject.addProperty("messageId", messageAreaService.getNewMessageId());
            }

        }catch (Exception e){
            e.printStackTrace();
           jsonObject.addProperty("result",0);
        }

        return jsonObject.toString();
    }

}
