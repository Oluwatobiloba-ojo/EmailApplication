package org.example.util;

import org.example.data.model.Mail;
import org.example.dto.request.SendEmailRequest;

public class Mapper {
    public  static Mail mapMail(SendEmailRequest sendEmailRequest){
        Mail mail = new Mail();
        mail.setTitle(sendEmailRequest.getTitle());
        mail.setMailType(MailType.SENT);
        mail.setMessage(sendEmailRequest.getBody());
        return mail;
    }
}
