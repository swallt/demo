package com.zhousx.demo;

import com.zhousx.util.SendEmail;

import java.util.ArrayList;
import java.util.List;

public class mailTestNew {
    public static void main(String[] args){
        List<String> map = new ArrayList<>();
//        map.add("zhousx@citytsm.com");
//        map.add("1191453570@qq.com");
        new SendEmail("zhousx@citytsm.com","Zsx2018!")
//                .setDebug(true)
                .setMyNickName("zhou1")
                .addFile("C:\\Users\\zhoushx\\Desktop\\suzhoujtb\\1.txt")
                .addRecipientT0("1191453570@qq.com")
                .addRecipientCC(map)
                .createMail("退费文件处理","退费文件","text/html;charset=utf-8")
                .sendEmail(new SendEmail.Callback() {
                    String i = "a";
                    {
                        System.out.println(i);
                    }

                    @Override
                    public void success(String s) {
                        i = s;
                        System.out.println(s + i);
                    }

                    @Override
                    public void error(String s, Exception e) {
                        i = s;
                        System.out.println(s+ i);
                        e.printStackTrace();
                    }
                });
    }
}
