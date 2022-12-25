package ru.mirea.lab30_2.BTree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}
