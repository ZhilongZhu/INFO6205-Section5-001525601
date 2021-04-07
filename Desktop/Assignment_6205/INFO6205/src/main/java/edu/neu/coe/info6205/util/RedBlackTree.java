package edu.neu.coe.info6205.util;
public class RedBlackTree {
    public static boolean RED = true;
    public static boolean BLACK = false;

    public Node root;

    public class  Node {
        public int key;
        public Integer val;
        public Node left, right;
        public int N;
        public boolean color;

        Node(int key, int val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public int size() {
        return size(root);
    }

    private int size(Node h){
        if (h == null) return 0;
        return h.N;
    }

    public void put(int key, int val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put (Node h, int key, int val) {
        if (h == null) return new Node(key, val, 1, RED);

        if (key < h.key) h.left = put(h.left, key, val);
        else if (key > h.key) h.right = put(h.right, key, val);
        else h.val = val;

        // balance this tree
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public Integer get(int key) {
        return get(root, key);
    }

    private Integer get(Node h, int key) {
        if (h == null) return null;
        if (key < h.key) return get(h.left, key);
        else if (key > h.key) return get(h.right, key);
        else return h.val;
    }

    public boolean noRedLinks() {
        return noRedLinks(root);
    }
    private boolean noRedLinks(Node h) {
        if (h == null) return true;

        if (h.color == RED && h.left != null) {
            if (h.left.color == RED) return false;
        }

        if (h.color == RED && h.right != null) {
            if (h.right.color == RED) return false;
        }

        return noRedLinks(h.left) && noRedLinks(h.right);
    }
}
