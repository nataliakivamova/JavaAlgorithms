package Lesson3;

public class ReversArray {

    private static String stringRevers(String arr){

        StringBuilder sb = new StringBuilder();

        for(int i = arr.length() - 1; i >= 0; i--){
            sb.append(arr.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String string = "Welcome to my world";
        System.out.println(stringRevers(string));
    }
}
