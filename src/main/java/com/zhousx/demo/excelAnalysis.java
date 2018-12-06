package com.zhousx.demo;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class excelAnalysis {
    public static void main(String[] args){
        File file = new File("C:\\Users\\zhoushx\\Desktop\\suzhoujtb\\download\\FB20181106.xls");
        try {
            Workbook workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            int cols = sheet.getColumns();
            System.out.println("行："+rows + "  列："+cols);
            for (int x = 1; x < rows; x++) {
                for (int y = 0; y < cols ; y++) {
                    System.out.println(sheet.getCell(y,x).getContents());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

    }
}
