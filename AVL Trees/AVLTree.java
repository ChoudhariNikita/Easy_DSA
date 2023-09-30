class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    int height;

    public TreeNode(int data) {
        this.data = data;
        this.height = 1;
    }
}

public class AVLTree {
    private TreeNode root;

    public AVLTree() {
        root = null;
    }

    // Helper function to get the height of a node
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Helper function to calculate the balance factor of a node
    private int balanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Rotate right to fix balance
    private TreeNode rotateRight(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Rotate left to fix balance
    private TreeNode rotateLeft(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a node into the AVL tree
    public TreeNode insert(TreeNode node, int data) {
        // Perform standard BST insertion
        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            // Duplicate data is not allowed
            return node;
        }

        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get balance factor to check if this node became unbalanced
        int balance = balanceFactor(node);

        // Left Heavy: Right Rotation
        if (balance > 1 && data < node.left.data) {
            return rotateRight(node);
        }

        // Right Heavy: Left Rotation
        if (balance < -1 && data > node.right.data) {
            return rotateLeft(node);
        }

        // Left Heavy: Left-Right Rotation
        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Heavy: Right-Left Rotation
        if (balance < -1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Insert data into the AVL tree
    public void insert(int data) {
        root = insert(root, data);
    }

    // In-order traversal of the AVL tree (for demonstration)
    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    // In-order traversal method (for demonstration)
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert some data to create an AVL tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("In-order traversal of AVL tree:");
        tree.inOrderTraversal();
    }
}
