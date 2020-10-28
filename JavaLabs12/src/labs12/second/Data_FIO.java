package labs12.second;

public class Data_FIO {
    private String text;
    private String name;
    private String surname;
    private String middle_name;
    private int count_space;

    void set_text(String text){
        this.text = text.substring(0, text.length()-2);
    }

    boolean correct_sym(char sym){
        int num = Integer.valueOf(sym);
        if((num >= 65 && num <=90) || (num >=97 && num <= 122) || (num >= 1040 && num<= 1103)
                || sym == '-' || sym == ' ')return true;
        return false;
    }

    boolean correct_text(){
        int count_space = 0;
        for (int i = 0; i < text.length(); i++){
            if (!correct_sym(text.charAt(i))) return false;
            if (i != text.length()-1) {
                if (text.charAt(i) == ' ' && text.charAt(i + 1) != ' ') count_space++;
                else if (text.charAt(i) == ' ' && (text.charAt(i + 1) == ' ' || i == 0)) return false;
            }else if (i == text.length()-1 && text.charAt(i) == ' ') return false;
        }
        if (count_space != 1 && count_space != 2){
            return false;
        }else
            return true;
    }


    String getName(){ return name;}

    void set(){
        int endSurname = 0;
        while(text.charAt(endSurname) != ' ') endSurname++;
        surname = text.substring(0, endSurname);

        int beginName = endSurname;
        int endName = beginName +1;
        while (endName != text.length()-1 && text.charAt(endName+1) != ' ') endName++;
        name = text.substring(beginName+1, endName+1);

        if (endName != text.length()-1){
            int beginMiddle_name = endName+2;
            middle_name = text.substring(beginMiddle_name, text.length());
        }else
            middle_name = "";
    }

    String getSurname(){ return surname;}

    String getMiddle_name(){return middle_name;}

}
