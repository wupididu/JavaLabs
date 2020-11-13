package thirt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Copy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("addressIN: ");
            String address1 = in.nextLine();
            System.out.print("addressOUT: ");
            String address2 = in.nextLine();
            copingFolder(address1,address2);
            System.out.println();
        }
    }

    static void copingFolder(String address1, String address2){
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
        }catch (Exception ex) {
            ex.printStackTrace();
        }

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
