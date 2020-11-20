package Network_Programming.UDP;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(6666);
        for (; ; ) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet); // 收取一个UDP数据包
            // 收取到的数据存储在buffer中，由packet.getOffset(), packet.getLength()指定起始位置和长度
            // 将其按UTF-8编码转换为String:
            String s=new String(packet.getData(),packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
            // 发送数据:
            byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
            packet.setData(data);
            ds.send(packet);


        }
    }


}
