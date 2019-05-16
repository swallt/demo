package com.zhousx.webspider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebSpiderTest {
    public static void main(String[] args) throws Exception {
        getArticles();
    }

    public static void getArticles() throws IOException{
        String url = "http://www.jianshu.com";

        Document doc = Jsoup.connect(url).get();
        Elements articlelinks = doc.select("a[class=\"title\"]");

        print("\nLinks: (%d)",articlelinks.size());
        for (Element link : articlelinks){
            print(" * a: <%s> (%s)",link.attr("abs:href"),link.text());
        }
    }

    private static void print(String msg, Object... args){
        System.out.println(String.format(msg,args));
    }
}
