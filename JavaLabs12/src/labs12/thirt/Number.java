package labs12.thirt;

public class Number {
    private String phoneNumber;
    private int begin_index = 0;
    private String correct_number = "+7 (";

    void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    void setBegin_index(int index) {
        begin_index = index;
    }

    int getBegin_index(){return begin_index;}

    String refactor_number(){
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
        for (int i = 0; i < phoneNumber.length()-10; i++) {
            if (phoneNumber.charAt(i) == '8' || phoneNumber.substring(i, i+2).equals("+7")) {
                int count_digit = 0;
                for (int j = i; j < phoneNumber.length(); j++) {
                    if (phoneNumber.charAt(j) >= '0' && phoneNumber.charAt(j) <= '9') count_digit++;
                }
                if (count_digit == 11) {
                    if (phoneNumber.charAt(i) == '8')begin_index = i+1;
                    else if(phoneNumber.substring(i, i+2).equals("+7")) begin_index = i+2;
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
