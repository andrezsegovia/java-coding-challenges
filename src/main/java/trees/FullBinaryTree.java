package trees;

public class FullBinaryTree {

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

        boolean isFullBinaryTree(Node node) {
            if(node == null)
                return true;
            if(node.left == null && node.right == null)
                return true;
            if(node.left != null && node.right != null) {
                return isFullBinaryTree((node.left)) && isFullBinaryTree(node.right);
            }
            return false;
        }

    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.right = new Node(15);

        System.out.printf("Is the tree full binary tree? %s%n", tree.isFullBinaryTree(tree.root)?"Yes":"No");

        tree.root.right.left = new Node(18);

        System.out.printf("Is the tree full binary tree? %s%n", tree.isFullBinaryTree(tree.root)?"Yes":"No");
        
    }
}

