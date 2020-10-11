package Lab10;

public class Calculation {
    public double calc(Double n1, String op, Double n2){
        double res = 0;
        switch (op) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                res = n1 / n2;
                break;
            default:
                res = 0;
                break;
        }
        return res;
        }
    }

