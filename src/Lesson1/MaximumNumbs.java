package Lesson1;

public class MaximumNumbs {
    public static void main(String[] args) {

        int[] arr = {7, -4, 38, 0, -6, 10, -33, 55, -3};
        int max1 = arr[0];
        int max2 = arr[0];

        for (int value : arr) {

            if (value > max1) {
                max2 = max1;
                max1 = value;
            }

            if (value < max1 && value > max2) {
                max2 = value;
            }
        }
            System.out.println("Первое максимальное число: " + max1 + "\nВторое максимальное число: " + max2);
        }
    }

// Линейная сложность

