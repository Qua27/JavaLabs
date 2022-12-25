package ru.mirea.lab30_1;

public class TestTree {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        for (int i = 0; i < 10; i++) {
            bsTree.add(i + 1);
        }
        bsTree.traverseTree();
        System.out.print('\n');
        bsTree.delete(4);
        bsTree.traverseTree();
        System.out.print('\n');
    }
}
