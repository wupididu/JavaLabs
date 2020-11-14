package second;


import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import first.Logger;

public class Louder {

    public static void main(String[] args) {
        ArrayList <String> list = new ArrayList<>();
        while (true){
            Scanner in = new Scanner(System.in);
            System.out.print("Folder: ");
            String folder = in.nextLine();
            if(folder.equals("CLOSE")) break;
            list.add(sizeOfDerict(folder));
        }
        Logger.log(list);
    }

    static String sizeOfDerict(String address){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        try{
            File folder = new File(address);
            System.out.print("Размер папки " + address + " ");
            long size = folderSize(folder);
            if(size > 1024*1024*1024) {
                double num = (double)size/(1024 * 1024 * 1024);
                System.out.print(decimalFormat.format(num));
                System.out.println(" Гбайт");
                return "Размер папки " + address + " " + decimalFormat.format(num) + " Гбайт";
            }else if(size > 1024*1024) {
                double num = (double)size/(1024 * 1024);
                System.out.print(decimalFormat.format(num));
                System.out.println(" Мбайт");
                return "Размер папки " + address + " " + decimalFormat.format(num) + " Мбайт";
            }else if (size > 1024) {
                double num = (double)size/1024;
                System.out.print(decimalFormat.format(num));
                System.out.println(" Кбайт");
                return "Размер папки " + address + " " + decimalFormat.format(num) + " Кбайт";
            }else {
                System.out.println(size + " байт");
                return "Размер папки " + address + " " + size + " Кбайт";
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Адресс " + address + " не найден";
    }

    static long folderSize(File directory){
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }
}
