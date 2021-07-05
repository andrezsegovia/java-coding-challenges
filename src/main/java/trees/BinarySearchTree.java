package trees;

public class BinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    void insert(int data) {
        this.root = insert(this.root, data);
    }

    Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    void inorder() {
        inorderRec(this.root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.printf("%d->", root.data);
            inorderRec(root.right);
        }
    }

    int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    Node delete(int data) {
        return delete(this.root, data);
    }

    Node delete(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root);
            root.right  = delete(root.right, root.data);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\n\nAfter deleting 10");
        tree.delete(10);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }
}
