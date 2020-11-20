package Network_Programming.Email;

import com.sun.mail.pop3.POP3SSLStore;

import javax.mail.*;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.IOException;
import java.util.Properties;

public class GetEmail {
    public static void main(String[] args) throws MessagingException, IOException {
        String host = "pop.qq.com";
        int port = 995;
        String username = "1142637274@qq.com";
        String password = "trokuknodyivjbdf";


        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "pop3"); // 协议名称
        props.setProperty("mail.pop3.host", host);// POP3主机名
        props.setProperty("mail.pop3.port", String.valueOf(port)); // 端口号
        // 启动SSL:
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", String.valueOf(port));

        // 连接到Store:
        URLName url = new URLName("pop3", host, port, "", username, password);
        Session session = Session.getInstance(props, null);
        session.setDebug(true); // 显示调试信息
        Store store = new POP3SSLStore(session, url);
        store.connect();

        // 获取收件箱:
        Folder folder = store.getFolder("INBOX");
        // 以读写方式打开:
        folder.open(Folder.READ_WRITE);
        // 打印邮件总数/新邮件数量/未读数量/已删除数量:
        System.out.println("Total messages" + folder.getMessageCount());
        System.out.println("New messages: " + folder.getNewMessageCount());
        System.out.println("Unread messages: " + folder.getUnreadMessageCount());
        System.out.println("Deleted messages: " + folder.getDeletedMessageCount());
        // 获取每一封邮件:
        Message[] messages = folder.getMessages();
        for (Message message : messages) {
            // 打印每一封邮件:
            printMessage((MimeMessage) message);
        }
    }

    static void printMessage(MimeMessage msg) throws IOException, MessagingException {
        // 邮件主题:
        System.out.println("Subject: " + MimeUtility.decodeText(msg.getSubject()));

    }
}
