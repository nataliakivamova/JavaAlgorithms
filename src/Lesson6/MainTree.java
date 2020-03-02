package Lesson6;

import javax.swing.*;
import java.util.Random;

public class MainTree {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            while (tree.heightOfTree() < 6) {
                tree.add(random.nextInt(200) - 100);
            }

            tree.isBalanced();
            tree = new Tree<>();
            System.out.println(tree);
        }
    }
}

