
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        Document doc;
        doc = Jsoup.connect("http://google.com").get();
        Elements links = doc.getElementsByTag("a");
        for(Element link: links) {
            String i = link.attr("href");
            if (i.length() > 0) {
                if (i.length() < 4)
                    i = doc.baseUri() + i.substring(1);
                else if (!i.substring(0, 4).equals("http"))
                    i = doc.baseUri() + i.substring(1);
            }
            System.out.println(i);


        }


    }
}
