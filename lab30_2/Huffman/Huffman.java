package ru.mirea.lab30_2.Huffman;

import java.util.PriorityQueue;

public class Huffman {
    private static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + "\t|\t" + s);
            return;
        }
        if (root.left != null && root.right != null) {
            printCode(root.left, s + "0");
            printCode(root.right, s + "1");
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[] charArray = {'A', 'B', 'C', 'D'};
        int[] charFrequency = {2, 4, 8, 5};
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(n, new ImplementComparator());
        for (int i = 0; i < n; i++) {
            HuffmanNode node = new HuffmanNode();
            node.c = charArray[i];
            node.item = charFrequency[i];
            node.left = null;
            node.right = null;
            queue.add(node);
        }
        HuffmanNode root = null;
        while (queue.size() > 1) {
            HuffmanNode x = queue.poll();
            HuffmanNode y = queue.poll();
            HuffmanNode f = new HuffmanNode();
            assert y != null;
            f.item = x.item + y.item;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            queue.add(f);
        }
        assert root != null;
        printCode(root, "");
    }
}
