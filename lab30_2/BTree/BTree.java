package ru.mirea.lab30_2.BTree;

public class BTree {
    Node root;

    public int height(Node p) {
        int h1 = 0;
        int h2 = 0;
        if (p == null) {
            return 0;
        }
        if (p.left != null) {
            h1 = height(p.left);
        }
        if (p.right != null) {
            h2 = height(p.right);
        }
        return Math.max(h1, h2) + 1;
    }

    public void reverse(Node treeNode) {
        if (treeNode == null) {
            return;
        }
        Node temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
        reverse(treeNode.left);
        reverse(treeNode.right);
    }

    public int lookup(Node node, int target) {
        if (node == null) {
            return 0;
        } else {
            if (target == node.value) {
                return 1;
            } else {
                if (target < node.value) {
                    return lookup(node.left, target);
                } else {
                    return lookup(node.right, target);
                }
            }
        }
    }

    public int getWidth(Node root, int level) {
        if (root == null) {
            return 0;
        }
        if (level == 1) {
            return 1;
        } else {
            return getWidth(root.left, level - 1) + getWidth(root.right, level - 1);
        }
    }

    public int getMaxWidth(Node root) {
        int maxWidth = 0;
        int width = 0;
        int h = height(root);
        for (int i = 1; i < h; i++) {
            width = getWidth(root, i);
            if (width > maxWidth) {
                maxWidth = width;
            }
        }
        return maxWidth;
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.left) + 1 + size(node.right);
        }
    }

    public boolean sameTree(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b != null) {
            return a.value == b.value && sameTree(a.left, b.left) && sameTree(a.right, b.right);
        } else {
            return false;
        }
    }
}
