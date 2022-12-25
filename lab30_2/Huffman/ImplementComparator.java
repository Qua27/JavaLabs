package ru.mirea.lab30_2.Huffman;

import java.util.Comparator;

public class ImplementComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.item - y.item;
    }
}
