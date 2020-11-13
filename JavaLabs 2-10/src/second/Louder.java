package second;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Louder {

    public static void main(String[] args) {
        while (true){
            Scanner in = new Scanner(System.in);
            System.out.print("Folder: ");
            sizeOfDerict(in.nextLine());
        }
    }

    static void sizeOfDerict(String address){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        try{
            File folder = new File(address);
            System.out.print("Размер папки " + address + " ");
            long size = folderSize(folder);
            if(size > 1024*1024*1024) {
                double num = (double)size/(1024 * 1024 * 1024);
                System.out.print(decimalFormat.format(num));
                System.out.println(" Гбайт");
            }else if(size > 1024*1024) {
                double num = (double)size/(1024 * 1024);
                System.out.print(decimalFormat.format(num));
                System.out.println(" Мбайт");
            }else if (size > 1024) {
                double num = (double)size/1024;
                System.out.print(decimalFormat.format(num));
                System.out.println(" Кбайт");
            }else
                System.out.println(size + " байт");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
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
