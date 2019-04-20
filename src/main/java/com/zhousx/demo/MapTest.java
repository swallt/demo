package com.zhousx.demo;

import java.util.ArrayList;
import java.util.List;

public class MapTest {
    public static void main(String[] args){

/*        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            Map<String, String> map = new HashMap<String, String>();
//            map.put("id",i+"");
//            map.put("sum",i+i+"");
            mapList.add(map);
        }
        for (Map map1: mapList) {
            System.out.println(map1.get("id")+"sum:  "+map1.get("sum"));
        }*/
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("3");
        list.add("8");
        list.add("6");
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
