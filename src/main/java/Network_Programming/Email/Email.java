package Network_Programming.Email;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Email {
    public static void main(String[] args) throws MessagingException {
        // 服务器地址:
        String smtp = "smtp.office365.com";
        // 登录用户名:
        String username = "zztlzxn@outlook.com";
        // 登录口令:
        String password = "zxn1998312";
        // 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "587"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // 设置debug模式便于调试:
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        //设置发送方地址
        message.setFrom(new InternetAddress("zztlzxn@outlook.com"));
        message.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress("1142637274@qq.com")));
        message.setSubject("helooooo", "UTF-8");
        message.setText("xiaonanhaoya", "UTF-8");
        Transport.send(message);
    }
}
