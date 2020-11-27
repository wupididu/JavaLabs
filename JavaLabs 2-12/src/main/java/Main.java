import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("VM does not support mandatory encoding UTF-8");
        }

        String URL = "https://www.moscowmap.ru/metro.html#lines";
        Document doc = Jsoup.connect(URL).get();

        Elements elements = doc.getElementsByAttributeValueContaining("class", "js-metro-line");

        ArrayList<String> list = new ArrayList<>();

        Metro metro = new Metro();

        elements.forEach(element -> {
            Lines lines = new Lines();
            lines.name = element.ownText().toString();
            lines.num = element.attr("data-line");
            metro.lines.add(lines);
            Elements children = doc.getElementsByAttributeValue("data-line", lines.num);
            ArrayList<String> nameList = new ArrayList<>();
            children.forEach(child -> {
                child.getElementsByClass("name").forEach(elem -> {
                    nameList.add(elem.ownText());
                });
            });
            metro.stations.put(lines.num,nameList);

        });
        Gson json = new Gson();

        String l = json.toJson(metro);
        list.add(l);
        try {
            Files.write(Path.of("data/metro.json"), list);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        Metro metroRead = json.fromJson(parseFile("data/metro.json"), Metro.class);

        ArrayList<String> log = new ArrayList<>();
        metro.lines.forEach(lines -> {
            System.out.println(lines.name + " " + metro.stations.get(lines.num).size() + " станций");
            log.add(lines.name + " " + metro.stations.get(lines.num).size() + " станций");
        });
        try {
            Files.write(Path.of("data/file.txt"), log);
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }

    public static String parseFile(String URL) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> files = Files.readAllLines(Paths.get(URL));

            files.forEach(file -> builder.append(file).append("\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }

    static class Metro {
        public List<Lines> lines = new ArrayList<>();
        public Map<String,ArrayList<String>> stations = new TreeMap<>();
    }

    static class Lines{
        public String num;
        public String name;
    }





}