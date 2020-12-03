import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String srcFolder = "images";
        String dstFolder = "dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        try
        {
            if (!Files.exists(Paths.get(dstFolder)))
            {
                Files.createDirectories(Paths.get(dstFolder));
            }
            ArrayList<File[]> arrayList = new ArrayList<>();
            int pastPart = files.length/8;
            for(int i = 0; i < 8; i++){
                int size;
                if (i == 7){
                    size = files.length - pastPart*7;
                } else
                    size = pastPart;
                File[] tempFlies = new File[size];
                arrayList.add(tempFlies);
                System.arraycopy(files, pastPart*i,tempFlies, 0, size);
            }
            arrayList.forEach(filesOfList -> {
                new Thread(new ImageResize(filesOfList, dstFolder, start)).start();
            });
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}