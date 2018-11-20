package cs.sicnu.fiveg.controller;

import com.google.gson.Gson;
import cs.sicnu.fiveg.dao.EmailVertificationService;
import cs.sicnu.fiveg.dao.UserInfoService;
import cs.sicnu.fiveg.pojo.EmailVertification;
import cs.sicnu.fiveg.pojo.UserInfo;
import cs.sicnu.fiveg.util.MailHelper;
import cs.sicnu.fiveg.util.Md5Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    EmailVertificationService emailVertificationService;
    /**
     *
     * @param userName
     * @param password
     */

    @ResponseBody
    @PostMapping ("/login")
    public String login(String userName, String password, HttpServletResponse response) throws UnsupportedEncodingException {
        UserInfo userInfo=userInfoService.queryUserInfoByName(userName);
        String md5pwd=userInfo==null?null:userInfo.getUserPassword();
        String toconfig=Md5Helper.getMd5Code(password+"["+userName+"]");
        if(md5pwd!=null&&md5pwd.equals(toconfig)){

            Cookie cookie=new Cookie("username",URLEncoder.encode(userName,"utf-8"));
            Cookie cookie1=new Cookie("useremail",
                    URLEncoder.encode(userInfo.getUserEmail(),"utf-8"));
            Cookie cookie2=new Cookie("usernickname",
                    URLEncoder.encode(userInfo.getUserNickName()==null?"":userInfo.getUserNickName(),"utf-8"));
            Cookie cookie3=
                    new Cookie("userid",URLEncoder.encode(userInfo.getUserId()==null?"":
                                    userInfo.getUserId().toString(),
                            "utf-8"));
            cookie.setPath("/");
            cookie1.setPath("/");
            cookie2.setPath("/");
            cookie3.setPath("/");
            response.addCookie(cookie);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.addCookie(cookie3);
            return 1+"";
        }else {
            return -1+"";
        }
    }

    /**
     *
     * @param formdata
     * @return
     */
    @ResponseBody
    @PostMapping (value = "/modifyuser",produces = "application/json;charset=utf8")
    public String  modifyUser(String formdata){
        UserInfo userInfo=new Gson().fromJson(formdata,UserInfo.class);
        int res=userInfoService.updateUserInfoById(userInfo);
        return res+"";
    }

    /**
     *
     * @param userName
     * @return
     */
    @ResponseBody
    @PostMapping (value = "/userInfo",produces = "application/json;charset=utf8")
    public String userInfo(String userName) {
        UserInfo userInfo=userInfoService.queryUserInfoByName(userName);
        return new Gson().toJson(userInfo);
    }

    /**
     *
     * @param email
     * @return
     */
    @ResponseBody
    @PostMapping ("/getvertifcode")
    public String sendEmail(String email){
        synchronized (this){
            EmailVertification emailVertification
                    =emailVertificationService.hasVaildVertification(email);
            if(emailVertification!=null){
                if(isOverDue(emailVertification.getEmailDate())){
                    emailVertificationService.overdue(email);
                    String code=MailHelper.generateCode(5);
                    emailVertificationService.sendEmail(email,code);
                    return 1+"";
                }else{
                    return 0+"";
                }
            }
            else {
                String code=MailHelper.generateCode(5);
                emailVertificationService.sendEmail(email,code);
                MailHelper.sendEmail(email,code);
            }
        }

        return 1+"";
    }


    @RequestMapping(value = "/usercenter")
    public String usercenter(){
        return "usercenter";
    }

    /**
     *
     * @param randomCode
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register")
    public String register(String randomCode,String email){
        EmailVertification emailVertification=emailVertificationService.hasVaildVertification(email);
        if(emailVertification!=null&&emailVertification.getVaild()==1){
            if(randomCode.equals(emailVertification.getVrtificationcode())){
                if(isOverDue(emailVertification.getEmailDate())){
                    return 0+"";
                }
                emailVertificationService.overdue(email);
                return 1+"";
            }
        }
        return 0+"";
    }

    /**
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/registernow")
    public String registerNow(String user){
        UserInfo userInfo=new Gson().fromJson(user,UserInfo.class);
        userInfo.setUserPassword(Md5Helper.getMd5Code(
                userInfo.getUserPassword()+"["+userInfo.getUserName()+"]"
        ));
        int res=userInfoService.insertUserInfo(userInfo);
        return res+"";
    }

    private boolean isOverDue(Date date){
        Date now =new Date(System.currentTimeMillis());
        long t=now.getTime()-date.getTime();
        long m=TimeUnit.MINUTES.convert(t,TimeUnit.MILLISECONDS);
        return m>=0;
    }

}
