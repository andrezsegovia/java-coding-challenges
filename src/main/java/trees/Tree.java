package trees;

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

    }
}
