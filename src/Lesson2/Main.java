package Lesson2;

import java.util.Random;

public class Main {
    private final static int size = 30; // взяла конкретное значение размера, чтобы посмотреть как код отрабатывает

    public static void main(String[] args) {
        ArrayList arr = new ArrayList(size);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
        arr.insert(random.nextInt(100));}
        arr.display();
        arr.find(10);
        arr.delete(34);
        arr.insert(6);
        arr.display();
    }
}
