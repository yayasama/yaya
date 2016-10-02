package com.yaya.demo.plugin.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 邮件任务
 *
 * @author ChW 2016-04-25 13:52:02
 */

@Component
public class MailTask {

    @Autowired
    private JavaMailSenderImpl mailSender;

    public void sendMail() {
        String title = "通知";
        String to = "qq.com";
        String content = "<html></html>";

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setSubject(title);
            helper.setTo(to);
            helper.setText(content, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(message);
    }

}
