package com.kingboy.common.utils.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

/**
 * 封装Email相关的操作.
 * <p></p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public final class EmailUtil {

    static Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    private Properties properties = new Properties();
    /**
     * Message对象将存储我们实际发送的电子邮件信息，
     */
    private MimeMessage message;

    /**
     * Session类代表JavaMail中的一个邮件会话。
     */
    private Session session;


    private Transport transport;
    private String mailHost = "";
    private int port = 25;
    private boolean auth = false;
    private String username = "";
    private String password = "";

    /*
     * 初始化方法
     */
    public EmailUtil(String host, Integer port, Boolean needAuth, String username, String password, boolean debug) {

        this.mailHost = host;
        this.port = port;
        this.auth = needAuth;
        this.username = username;
        this.password = password;

        properties.put("mail.smtp.host", mailHost);
        properties.put("mail.smtp.auth", auth);
        properties.put("mail.smtp.port", String.valueOf(25));
        properties.put("mail.sender.username", username);
        properties.put("mail.sender.password", password);

        session = Session.getInstance(properties);
        session.setDebug(debug); //开启后有调试信息
        message = new MimeMessage(session);
    }

    /**
     * 发送邮件
     *
     * @param subject     邮件主题
     * @param sendHtml    邮件内容
     * @param receiveUser 收件人地址
     */
    public void doSendHtmlEmail(String subject, String sendHtml, String receiveUser) {
        try {
            // 发件人
            InternetAddress from = new InternetAddress(username);
            // 下面这个是设置发送人的Nick name
            //InternetAddress from = new InternetAddress(MimeUtility.encodeWord("幻影") + " <" + sender_username + ">");
            message.setFrom(from);

            // 收件人
            InternetAddress to = new InternetAddress(receiveUser);
            message.setRecipient(Message.RecipientType.TO, to); //还可以有CC、BCC

            // 邮件主题
            message.setSubject(subject);

            String content = sendHtml.toString();
            // 邮件内容,也可以使纯文本"text/plain"
            message.setContent(content, "text/html;charset=UTF-8");

            // 保存邮件
            message.saveChanges();

            transport = session.getTransport("smtp");
            // smtp验证，就是你用来发邮件的邮箱用户名密码
            transport.connect(mailHost, port, username, password);
            // 发送
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


    /**
     * 发送邮件
     *
     * @param subject     邮件主题
     * @param sendHtml    邮件内容
     * @param receiveUser 收件人地址
     * @param attachment  附件
     */
    public void doSendHtmlEmail(String subject, String sendHtml, String receiveUser, File attachment) {
        try {
            // 发件人
            InternetAddress from = new InternetAddress(username);
            message.setFrom(from);
            // 收件人
            InternetAddress to = new InternetAddress(receiveUser);
            message.setRecipient(Message.RecipientType.TO, to);
            // 邮件主题
            message.setSubject(subject);
            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();
            // 添加邮件正文
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(sendHtml, "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);
            // 添加附件的内容
            if (attachment != null) {
                BodyPart attachmentBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(attachment);
                attachmentBodyPart.setDataHandler(new DataHandler(source));
                //MimeUtility.encodeWord可以避免文件名乱码
                attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
                multipart.addBodyPart(attachmentBodyPart);
            }
            // 将multipart对象放到message中
            message.setContent(multipart);
            // 保存邮件
            message.saveChanges();
            transport = session.getTransport("smtp");
            // smtp验证，就是你用来发邮件的邮箱用户名密码
            transport.connect(mailHost, port, username, password);
            // 发送
            transport.sendMessage(message, message.getAllRecipients());
            logger.info("send success!");
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
