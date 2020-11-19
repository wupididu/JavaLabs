package Laba13.third;

public class Number {
    private String phoneNumber;
    private int begin_index = 0;
    private String correct_number;
    private String list;

    void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    void setBegin_index(int index) {
        begin_index = index;
    }

    int getBegin_index(){return begin_index;}

    String refactor_number(){
        correct_number = "+7 (";
        int i = begin_index;
        int count_number = 0;
        while(count_number < 3){
            if(phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9'){
                correct_number += phoneNumber.charAt(i);
                count_number ++;
            }
            i++;
        }
        correct_number += ") ";
        count_number = 0;
        while(count_number < 3){
            if(phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9'){
                correct_number += phoneNumber.charAt(i);
                count_number ++;
            }
            i++;
        }

        correct_number += "-";

        count_number = 0;
        while(count_number < 2){
            if(phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9'){
                correct_number += phoneNumber.charAt(i);
                count_number ++;
            }
            i++;
        }

        correct_number += "-";

        count_number = 0;
        while(count_number < 2){
            if(phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9'){
                correct_number += phoneNumber.charAt(i);
                count_number ++;
            }
            i++;
        }

        return correct_number;

    }

    boolean correct_number(){
        list = "";
        for (int i = 0; i < phoneNumber.length();i++){
            if (phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9'){
                list += phoneNumber.charAt(i);
            }
        }
        if((list.length() == 11 && (list.charAt(0) == '8' || list.charAt(0) == '7') || list.length() == 10)){
            begin_index = list.length() - 10;
            return true;
        }
        return false;
    }
}
