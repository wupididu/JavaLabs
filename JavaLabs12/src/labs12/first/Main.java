package labs12.first;

public class Main {
    public static void main(String[] args) {
        Main main =new Main();
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int num1 = main.get_num(text, "Вася");
        int num2 = main.get_num(text, "Маша");
        if (num1 < 0 || num2 < 0) return;
        System.out.println(num1+num2);
    }

    int get_last_index(String text, String word){
        int i = 0;
        while(i < text.length()){
            if (text.charAt(i) == word.charAt(0)){
                boolean flag = true;
                for (int j = i; j < word.length()+i; j++){
                    if(text.charAt(j) != word.charAt(j-i)) flag = false;
                }
                if (flag) return i+word.length();
            }
            i++;
        }

        return -1;
    }

    int get_num(String text, String word){
        Main main = new Main();
        if (main.get_last_index(text,word)==-1) return -1;
        int index = main.get_last_index(text,word);
        while(!Character.isDigit(text.charAt(index))){ index++;}
        int i = index;
        while(text.charAt(i) != ' '){ i++;}
        String num = text.substring(index, i);
        return Integer.parseInt(num);
    }

}
