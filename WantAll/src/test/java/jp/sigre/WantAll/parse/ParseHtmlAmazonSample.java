package jp.sigre.WantAll.parse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ParseHtmlAmazonSample {

    public static void main(String[] args) throws IOException, ParseException {
    	String UrlRequest = "http://www.amazon.co.jp/dp/B00MO082E0/ref=wl_it_dp_o_pC_S_ttl?_encoding=UTF8&colid=G6HCBUEJUOCZ&coliid=I1W6D978QU0AOL";
        Document //document = Jsoup.connect("http://www.amazon.co.jp/dp/B00MO082E0/ref=wl_it_dp_o_pC_S_ttl?_encoding=UTF8&colid=G6HCBUEJUOCZ&coliid=I1W6D978QU0AOL").get();
        document = Jsoup.connect(UrlRequest).timeout(30000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").get();
        Element element1 = document.getElementById("productTitle");
        String workName = element1.text();
        System.out.println(workName);
        System.out.println();

        Element element2 = document.getElementById("brand");
        String workMaker = element2.text();
        System.out.println(workMaker);
        System.out.println();

        Element element3 = document.getElementById("detail_bullets_id");
        String workRelease = element3.getElementsByTag("li").get(4).text();
        System.out.println(workRelease);
        System.out.println();

        DateFormat df = new SimpleDateFormat("発売日： yyyy/MM/dd");
        Date date = df.parse(workRelease);
        String dateStr = new SimpleDateFormat("yyyyMMdd").format(date);
        int dateInt = Integer.parseInt(dateStr);
        System.out.println(dateInt);
    }
}
