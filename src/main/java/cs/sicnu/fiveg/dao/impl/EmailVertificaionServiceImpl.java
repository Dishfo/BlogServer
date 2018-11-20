package cs.sicnu.fiveg.dao.impl;

import cs.sicnu.fiveg.dao.EmailVertificationService;
import cs.sicnu.fiveg.mapper.EmailVertificationMapper;
import cs.sicnu.fiveg.pojo.EmailVertification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailVertificaionServiceImpl implements EmailVertificationService{

    @Autowired
    EmailVertificationMapper emailVertificationMapper;

    @Override
    public EmailVertification hasVaildVertification(String email) {
        EmailVertification emailVertification=emailVertificationMapper.selectVild(email);
        return emailVertification;
    }

    @Override
    public int sendEmail(String email, String code) {
        EmailVertification emailVertification=new EmailVertification();
        emailVertification.setEmailAddress(email);
        emailVertification.setVaild(1);
        emailVertification.setVrtificationcode(code);
        return emailVertificationMapper.insert(emailVertification);
    }

    @Override
    public int overdue(String email) {
        return emailVertificationMapper.setVailed(email);
    }
}
