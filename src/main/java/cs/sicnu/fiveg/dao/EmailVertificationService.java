package cs.sicnu.fiveg.dao;

import cs.sicnu.fiveg.pojo.EmailVertification;

public interface EmailVertificationService {

    EmailVertification hasVaildVertification(String email);

    int sendEmail(String email,String code);

    int overdue(String email);
}
