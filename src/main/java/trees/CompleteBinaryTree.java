package trees;

public class CompleteBinaryTree {

    static class Node {
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

        int amountNodes(Node node) {
            if(node == null)
                return 0;
            return 1 + amountNodes(node.left) + amountNodes(node.right);
        }

        boolean isCompleteBinaryTree(Node node, int amountNodes, int index) {
            if(node == null)
                return true;

            if(index >= amountNodes)
                return false;

            return isCompleteBinaryTree(node.left, amountNodes, 2*index+1) &&
                    isCompleteBinaryTree(node.right, amountNodes, 2*index+2);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree( new Node(1) );
        tree.root.left = new Node(12);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.right = new Node(15);

        System.out.printf("is a complete binary tree? %B%n", tree.isCompleteBinaryTree(tree.root, tree.amountNodes(tree.root), 0));

        tree.root.right.right = new Node(17);

        System.out.printf("is a complete binary tree? %B%n", tree.isCompleteBinaryTree(tree.root, tree.amountNodes(tree.root), 0));

    }
}
