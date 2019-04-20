package com.zhousx.demo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class NetTestClient {
    public static void main(String[] args) throws IOException {
        int port = 7001;
        String host = "localhost";
        //创建一个套接字并将其连接到指定端口号
        Socket socket = new Socket(host,port);

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

        Scanner sc = new Scanner(System.in);

        boolean flag = false;

        while (!flag){
            System.out.println("请输入正方形的边长");
            double length = sc.nextDouble();
            dos.writeDouble(length);
            dos.flush();

//            String data = "90000001019001000101900200010190050003333333";
//            TLVUtil tlvUtil = new TLVUtil();
//            TLV tlv;
//            tlvUtil.unpack(data);
//
//            for(int i=0;i<tlvUtil.tlvList.size();i++)
//            {
//                tlv = tlvUtil.tlvList.get(i);
//                System.out.print("   标签:["+i+"]"+"\n");
//                System.out.print("  tag:"+tlv.getTag()+"\n");
//                System.out.print("  len:"+tlv.getLen()+"\n");
//                System.out.print("value:"+ tlvUtil.bytesToHex(tlv.getValue())+"\n");
//            }

            double area = dis.readDouble();

            System.out.println("服务器返回的计算面积为： " + area);

            while (true){
                System.out.println("继续计算？（Y/N）");
                String str = sc.next();

                if(str.equalsIgnoreCase("N")){
                    dos.writeInt(0);
                    dos.flush();
                    flag = true;
                    break;
                }else if(str.equalsIgnoreCase("Y")){
                    dos.writeInt(1);
                    dos.flush();
                    break;
                }
            }
        }

        socket.close();
    }
}
