package second;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String URL = "https://www.mirea.ru";
        ArrayList<String> urlStack = new ArrayList<>();
        Document doc = Jsoup.connect(URL).get();

        Elements elements = doc.getElementsByTag("img");
        String u;
        elements.forEach(element -> {
            if (element.attr("src").equals(""))
                urlStack.add(element.absUrl("data-src"));
            else{
                urlStack.add(element.absUrl("src"));
            }
        });

        for (String url: urlStack){
            File folder = new File("images");
            if(!folder.exists()) folder.mkdir();
            File file = new File("images/" + url.split("/")[url.split("/").length-1]);
            LoadImage image = new LoadImage(url,file);
            image.load();
        }

    }
}
