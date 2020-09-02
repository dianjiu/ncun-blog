package cn.org.dianjiu.common.util;


import cn.org.dianjiu.common.pojo.dto.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Slf4j
public class EmailUtils {

    private static JavaMailSender mailSender;

    public static JavaMailSender getMailSender() {
        return mailSender;
    }

    public static void setMailSender(JavaMailSender mailSender) {
        if (null == EmailUtils.mailSender) {
            EmailUtils.mailSender = mailSender;
        }
    }

    public static void sendSimpleMail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(email.getFrom());
            message.setTo(email.getTo());
            message.setCc(email.getCc());//抄送人
            message.setBcc(email.getBcc());//密送人
            message.setSubject(email.getSubject());
            message.setText(email.getContent());
            mailSender.send(message);
            log.info("发送基础邮件成功！");
        } catch (MailException e) {
            log.error("发送基础邮件异常："+e);
        }
    }

    /**
     * 发送html邮件
     */
    public static void sendHtmlMail(Email email) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email.getFrom());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), true);
            mailSender.send(message);
            log.info("发送html邮件成功");
        } catch (MessagingException e) {
            log.error("发送html邮件异常:"+e);
        }
    }


    /**
     * 发送带附件的邮件
     */
    public static void sendAttachmentsMail(Email email) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email.getFrom());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), true);
            String[] filePaths=email.getFilePaths();
            for (String filePath : filePaths) {
                FileSystemResource file = new FileSystemResource(new File(filePath));
                String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                helper.addAttachment("点九附件:"+fileName, file);
            }
            mailSender.send(message);
            log.info("发送带附件的邮件成功！");
        } catch (MessagingException e) {
            log.error("发送带附件的邮件异常："+e);
        }
    }


    /**
     * 发送正文中有静态资源（图片）的邮件
     */
    public static void sendInlineResourceMail(Email email) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email.getFrom());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), true);
            FileSystemResource res = new FileSystemResource(new File(email.getRscPath()));
            helper.addInline(email.getRscId(), res);
            mailSender.send(message);
            log.info("发送嵌入图片的邮件成功！");
        } catch (MessagingException e) {
            log.error("发送嵌入图片的邮件异常："+e);
        }
    }
}