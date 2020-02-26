package Lesson5;

public class Exponentiation {

    private double exponentiation(double num, int exp) {
        if(exp > 0) {
            return num * exponentiation(num, exp - 1);
        } else if (exp < 0){
            return 1 / (num * exponentiation(num, -exp - 1));
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Exponentiation exponent = new Exponentiation();
        System.out.println(exponent.exponentiation(2,-2));
    }
}
