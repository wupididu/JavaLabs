package thirt;

import first.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Copy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(true) {
            System.out.print("go/close");
            String com = in.nextLine();
            while(!com.equals("go") && !com.equals("close")){
                System.out.println("go/close");
                com = in.next();
            }
            if(com.equals("close")) break;
            System.out.print("addressIN: ");
            String address1 = in.nextLine();
            list.add("addressIN: " + Paths.get(address1));
            System.out.print("addressOUT: ");
            String address2 = in.nextLine();
            list.add("addressOUT: " + Paths.get(address2));
            if(copingFolder(address1, address2)){
                list.add("DONE");
                System.out.println("DONE");
            }else {
                list.add("ERROR");
                System.out.println("ERROR");
            }
        }
        Logger.log(list);

    }

    static boolean copingFolder(String address1, String address2){
        try {
            File folder2 = new File(address2);
            File hfolder = new File(address1 + "/" + folder2.getName());
            if(!hfolder.exists()) hfolder.mkdir();

            for (File file: folder2.listFiles()){
                if(file.isFile()){
                    FileOutputStream in = new FileOutputStream(hfolder.getAbsolutePath() + "/" + file.getName());
                    for(char c: read(file.getAbsolutePath()).toString().toCharArray()){
                        in.write(c);
                    }
                }else{
                    copingFolder(address1 + "/" + folder2.getName(),file.getAbsolutePath());
                }
            }
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public static StringBuffer read(String address) {
        StringBuffer buffer = new StringBuffer();

        try {
            FileInputStream inputStream = new FileInputStream(address);

            while (true) {
                int code = inputStream.read();

                if (code < 0)
                    break;

                char ch = (char) code;
                buffer.append(ch);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return buffer;
    }
}
