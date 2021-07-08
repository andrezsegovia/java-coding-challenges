package trees;

import java.util.Map;
import java.util.TreeMap;

public class TopViewBST {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public static <U, V> Pair<U, V> of(U a, V b) {
            return new Pair<>(a, b);
        }
    }

    static void printTop(Node root) {
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
        printTop(root, 0, 0, map);
        for(Pair<Integer, Integer> item: map.values()) {
            System.out.printf("%d ", item.first);
        }
    }

    static void printTop(Node root, int dist, int level, Map<Integer, Pair<Integer, Integer>> map) {
        if(root == null) {
            return;
        }
        if(!map.containsKey(dist) || level < map.get(dist).second) {
            map.put(dist, Pair.of(root.data, level));
        }
        printTop(root.left, dist-1, level+1, map);
        printTop(root.right, dist+1, level+1, map);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        printTop(root);

    }
}
