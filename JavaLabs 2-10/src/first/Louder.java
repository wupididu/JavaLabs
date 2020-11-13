package first;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Louder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.print("Address: ");
            String address = in.nextLine();
            System.out.print("Text: ");
            String text = in.nextLine();
            setMess(address, text);
        }

    }
    static void setMess(String address,String text){
        try{
            String[] derict = address.split("/");
            File folder = null;
            for (int i = 0; i < derict.length-1; i++){
               folder = new File(folder, derict[i]);
               if(!folder.exists()) folder.mkdir();
            }
            FileOutputStream file = new FileOutputStream(address);
            for(char el: text.toCharArray()){
                file.write(el);
            }
            file.write('\n');
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
