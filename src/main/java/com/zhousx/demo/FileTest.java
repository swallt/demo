package com.zhousx.demo;

import com.acquirer.util.DateUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args){
        String checkAccDate = DateUtil.date2Stringyyyymmddhhmmss(DateUtil.addDay(new Date(), -1)).substring(0, 8);
        File file = new File("C:\\Users\\zhoushx\\Desktop\\suzhoujtb\\mail\\"+"FB"+checkAccDate+".xls");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
