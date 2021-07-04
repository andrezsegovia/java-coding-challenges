package trees;

public class BalanceBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Height {
        int height = 0;
    }

    static class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        boolean isBalance(Node node, Height height) {
            if(node == null) {
                height.height = 0;
                return true;
            }
            Height leftHeight = new Height();
            Height rightHeight = new Height();
            boolean left = isBalance(node.left, leftHeight);
            boolean right = isBalance(node.right, rightHeight);

            height.height = (leftHeight.height > rightHeight.height?leftHeight.height:rightHeight.height) + 1;

            if((leftHeight.height - rightHeight.height >= 2) || (rightHeight.height - leftHeight.height >= 2)) {
                return false;
            } else {
                return left && right;
            }
        }
    }

    public static void main(String[] args) {
        Height height = new Height();
        Tree tree = new Tree( new Node(1) );
        tree.root.left = new Node(12);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.right = new Node(15);

        System.out.printf("is a balance binary tree? %B%n", tree.isBalance(tree.root, height));

        tree.root.left.right.left = new Node(17);

        System.out.printf("is a balance binary tree? %B%n", tree.isBalance(tree.root, height));
    }
}
