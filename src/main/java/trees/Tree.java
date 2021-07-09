package trees;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.Map;
import java.util.TreeMap;

public class Tree {

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree() {
            this.root = null;
        }

        void postorder(Node node) {
            if(node == null)
                return;
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " -> ");
        }

        void inoder(Node node) {
            if(node == null)
                return;
            inoder(node.left);
            System.out.print(node.value + " -> ");
            inoder(node.right);
        }

        void preorder(Node node) {
            if (node == null)
                return;
            System.out.print(node.value + " -> ");
            preorder(node.left);
            preorder(node.right);
        }


        void levelOrder(Node node, int level, Map<Integer, StringBuilder> map) {
            if(node == null) {
                return;
            }
            map.compute(level, (key,value) -> value == null? new StringBuilder(String.valueOf(node.value)) : value.append(",").append(node.value));
            levelOrder(node.left, level+1, map);
            levelOrder(node.right, level+1, map);
        }
        void levelOrder(Node node) {
            Map<Integer, StringBuilder> map = new TreeMap<>();
            levelOrder(node, 0, map);
            map.forEach((key, value) -> {
                for (String str : value.toString().split(",")){
                    System.out.printf("%s ", str);
                }
            });
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(12);
        bt.root.left.left = new Node(5);
        bt.root.left.right = new Node(6);
        bt.root.right = new Node(15);

        System.out.println("\ninorder...");
        bt.inoder(bt.root);
        System.out.println("\npreorder...");
        bt.preorder(bt.root);
        System.out.println("\npostorder...");
        bt.postorder(bt.root);
        System.out.println("\nlevelorder...");
        bt.levelOrder(bt.root);


    }
}
