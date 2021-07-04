package trees;

public class PerfectBinaryTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        int depth(Node node) {
            int d = 0;
            while(node != null) {
                d++;
                node = node.left;
            }
            return d;
        }

        boolean isPerfect(Node node, int depth, int level) {
            if(node == null)
                return true;
            if(node.left == null && node.right == null)
                return (depth == level+1);
            if(node.left == null || node.right == null)
                return false;
            return isPerfect(node.left, depth, level+1) &&
                    isPerfect(node.right, depth, level+1);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree( new Node(1) );
        tree.root.left = new Node(12);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.right = new Node(15);

        System.out.printf("is a perfect binary tree? %B%n", tree.isPerfect(tree.root, tree.depth(tree.root), 0));

        tree.root.right.left = new Node(16);
        tree.root.right.right = new Node(17);

        System.out.printf("is a perfect binary tree? %B%n", tree.isPerfect(tree.root, tree.depth(tree.root), 0));
    }
}
