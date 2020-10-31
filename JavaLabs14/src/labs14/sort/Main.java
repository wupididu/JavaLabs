package labs14.sort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listCoolNumber = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        char[] letter = {'A','B','E','K','M','H','O','P','C','T','Y','X'};

        long count = 0;
        for(char X: letter){
            for(int i = 0;i<10;i++){
                for(char Y: letter){
                    for (char Z: letter){
                        String N = String.valueOf(i);
                        for (int R = 1; R < 10; R++){
                            listCoolNumber.add(X+ N + N + N + Y + Z + "0" + String.valueOf(R));
                            count ++;
                        }
                        for (int R = 10; R < 200; R++){
                            listCoolNumber.add(X+ String.valueOf(N+N+N) + Y + Z + String.valueOf(R));
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);

        System.out.print("Ввести номер: ");
        String number = in.next();

        System.out.print("Поиск перебором:");
        long start = System.nanoTime();
        boolean isit = listCoolNumber.contains(number);
        long end = System.nanoTime() - start;
        if(isit) System.out.println(" номер найден, поиск занял " + end + "нс");
        else System.out.println(" номер не найден, поиск занял " + end + "нс");

        System.out.print("Поиск бинарный:");
        Collections.sort(listCoolNumber);
        start = System.nanoTime();
        int index = Collections.binarySearch(listCoolNumber, number);
        end = System.nanoTime() - start;
        if(index >= 0) System.out.println(" номер найден, поиск занял " + end + "нс");
        else System.out.println(" номер не найден, поиск занял " + end + "нс");


        System.out.print("Поиск в HashSet:");
        HashSet<String> list = new HashSet<>(listCoolNumber);
        start = System.nanoTime();
        isit = list.contains(number);
        end = System.nanoTime() - start;
        if(isit) System.out.println(" номер найден, поиск занял " + end + "нс");
        else System.out.println(" номер не найден, поиск занял " + end + "нс");

        System.out.print("Поиск в TreeSet:");
        TreeSet<String> treeList = new TreeSet<>(listCoolNumber);
        start = System.nanoTime();
        isit = treeList.contains(number);
        end = System.nanoTime() - start;
        if(isit) System.out.println(" номер найден, поиск занял " + end + "нс");
        else System.out.println(" номер не найден, поиск занял " + end + "нс");

    }
}
