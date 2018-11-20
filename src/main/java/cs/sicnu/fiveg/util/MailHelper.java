package cs.sicnu.fiveg.util;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class MailHelper {

    public static final String sendEmailAddress="1771334691@qq.com";

    public static final String NUMS[]={"0","1","2","3","4","5","6","7","8","9"};
    public static String generateCode(int len){
        Random random=new Random();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<len;i++){
            stringBuilder.append(NUMS[random.nextInt(10)]);
        }

        return stringBuilder.toString();
    }


    public static void sendEmail(String email,String code){
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        properties.setProperty("mail.smtp.host", "smtp.qq.com"); // 发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.auth", "true"); // 需要请求认证

        final String smtpPort = "465";
        properties.setProperty("mail.smtp.port", smtpPort);
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", smtpPort);

        Session session = Session.getInstance(properties);
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        Transport transport = null;
        try {
            // 设置发件人
            message.setFrom(new InternetAddress(sendEmailAddress, "..", "utf-8"));
            // 设置收件人
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email, "XX用户", "utf-8"));
            // 设置主题
            message.setSubject("验证码", "utf-8");
            // 设置邮件的内容
            String content = "<p style=\"font-size: 20px;font-weight: bold;display: inline\">&emsp;&emsp;XX用户你好，欢迎使用我们的应用，你的验证码是:<p style=\"font-size: 30px;color: #F08080;display: inline;\">"
                    + code + "</p><p style=\"font-size: 20px;font-weight: bold;display: inline\">,请在10分钟之内使用<p><p>";
            message.setContent(content, "text/html;charset=UTF-8");
            message.setSentDate(new Date());

            message.saveChanges();
            transport = session.getTransport();

            transport.connect(sendEmailAddress, "oaqiykgcerqjbggj");
            transport.sendMessage(message, message.getAllRecipients());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
