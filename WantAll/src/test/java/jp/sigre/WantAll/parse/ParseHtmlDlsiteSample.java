package jp.sigre.WantAll.parse;

import java.io.IOException;
import java.text.ParseException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ParseHtmlDlsiteSample {

    public static void main(String[] args) throws IOException, ParseException {
        Document document = Jsoup.connect("http://www.dlsite.com/maniax/work/=/product_id/RJ146706.html").get();
        //System.out.println(document.html());

        Element element1 = document.getElementById("work_name");
        String workName = element1.getElementsByTag("h1").get(0).text();
        System.out.println(workName);
        System.out.println();

        Element element2 = document.getElementsByClass("maker_name").get(0);
        String workMaker = element2.getElementsByTag("span").get(0).text();
        System.out.println(workMaker);
        System.out.println();

        Element element3 = document.getElementById("work_outline");
        String workRelease = element3.getElementsByTag("td").get(0).text();



        System.out.println(workRelease);
        System.out.println();
    }

}

//<div class="base_title_br no_btn clearfix"><h1 itemprop="name" id="work_name">【アイヌ系】道草屋 すずな 囲炉裏の音【うたた寝音声】</h1></div>
//
//<div id="work_right_name">
//<table id="work_maker">
//<tr>
//<th>サークル名&nbsp;:&nbsp;</th>
//<td><span class="maker_name"><a href="http://www.dlsite.com/maniax/circle/profile/=/maker_id/RG24350.html"><span itemprop="brand">桃色CODE</span></a></span><span class="add_mygenre"><a href="http://www.dlsite.com/maniax/mypage/mygenre/add/=/work_id/RJ146706/product_state/1/maker_id/RG24350.html"><img src="/images/web/home/btn_mygenre.png" alt="" /></a></span></td>
//</tr>
//<tr><th>ホームページ&nbsp;:&nbsp;</th>
//<td><a rel="nofollow" href="http://momoirocode.web.fc2.com/" target="_blank">http://momoirocode.web.fc2.com/</a></td>
//</tr>
//</table>
//</div>

//<table cellspacing="0" id="work_outline">
//<tr>
//<th>販売日&nbsp;:&nbsp;</th>
//<td><a href="http://www.dlsite.com/maniax/new/=/year/2014/mon/12/day/23/cyear/2014/cmon/12">2014年12月23日</a></td></tr>
//<tr><th>シリーズ名&nbsp;:&nbsp;</th><td><a href="http://www.dlsite.com/maniax/fsr/=/keyword/%E3%80%90%E8%80%B3%E3%81%8B%E3%81%8D%E3%80%91%E9%81%93%E8%8D%89%E5%B1%8B%E3%80%90%E5%AE%89%E7%9C%A0%E3%80%91%20SRI0000007543/from/work.series">【耳かき】道草屋【安眠】</a></td></tr>
//<tr><th>年齢指定&nbsp;:&nbsp;</th><td><div class="work_genre">全年齢</div></td></tr>
//<tr><th>作品形式&nbsp;:&nbsp;</th><td><div class="work_genre"><span class="icon_SOF" title="同人ソフト"><a href="http://www.dlsite.com/maniax/fsr/=/work_category/doujin/work_type%5B0%5D/MDC/work_type%5B1%5D/ICG/work_type%5B2%5D/IN2/work_type%5B3%5D/NR2/work_type%5B4%5D/MOV/work_type%5B5%5D/TOL/work_type%5B6%5D/SOU/work_type%5B7%5D/MUS/work_type%5B8%5D/ET4/from/icon.work">同人ソフト</a></span><span class="icon_SOU" title="音声作品"><a href="http://www.dlsite.com/maniax/fsr/=/work_category%5B0%5D/doujin/work_type/SOU/from/icon.work">音声作品</a></span></div></td></tr>
//<tr><th>ファイル形式&nbsp;:&nbsp;</th><td><div class="work_genre"><span class="icon_MP3" title="オーディオ(MP3)"><a href="http://www.dlsite.com/maniax/fsr/=/work_category%5B0%5D/doujin/file_type/MP3/from/icon.work">オーディオ(MP3)</a></span>&nbsp;/&nbsp;WAV</div></td></tr>
//<tr><th>対応OS&nbsp;:&nbsp;</th><td>
//<dl class="os_pc"><dt>[PC]</dt><dd>WindowsVista / Windows7 / Windows8</dd></dl></td></tr>
//<tr><th>その他&nbsp;:&nbsp;</th><td><div class="work_genre"><span class="icon_SND" title="音声あり"><a href="http://www.dlsite.com/maniax/fsr/=/work_category%5B0%5D/doujin/options/SND/from/icon.work">音声あり</a></span><span class="icon_TRI" title="体験版あり"><a href="http://www.dlsite.com/maniax/fsr/=/work_category%5B0%5D/doujin/options/TRI/from/icon.work">体験版あり</a></span><span class="icon_REV" title="レビューあり"><a href="http://www.dlsite.com/home/work/reviewlist/=/product_id/RJ146706.html">レビューあり</a></span></div></td></tr>

