package first;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Logger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <String> list = new ArrayList<>();
            System.out.print("Text: ");
            list.add(in.nextLine());
            log(list);

    }
    public static void log(ArrayList<String> text){
        try{
            Files.write(Paths.get("data/log.txt"),text);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
