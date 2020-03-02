package Lesson6;

import javafx.scene.Node;

public class Tree<T> {
    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public void add (int value) {
        addRecursive (root, value);
    }

    private Node addRecursive(Node current, int value) {

        if(current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced (Node root) {
        if (root == null) {
            return true;
        } else {
            int leftH = heightOfTree(root.left);
            int rightH = heightOfTree(root.right);

            return Math.abs(leftH - rightH) <= 1;
        }
    }

    public int heightOfTree(){
        return heightOfTree(root);
    }

    private int heightOfTree(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
        }
    }
}
