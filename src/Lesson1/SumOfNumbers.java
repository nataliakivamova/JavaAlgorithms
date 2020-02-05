package Lesson1;

public class SumOfNumbers {
    public static void main(String[] args) {

        int[] arr = {-15, -14, -12, -10, -6, -4, -2, -1, 3, 4, 5, 8, 9, 11, 14, 19};
        int num1;
        int num2;
        int num3;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int z = j + 1; z < arr.length; z++) {
                    num1 = arr[i];
                    num2 = arr[j];
                    num3 = arr[z];

                    if ((num1 + num2 + num3) == 0) {
                        System.out.println("Результат: " + num1 + " " + num2 + " " + num3);
                    }
                }
            }
        }
    }
}
// Кубическая сложность






