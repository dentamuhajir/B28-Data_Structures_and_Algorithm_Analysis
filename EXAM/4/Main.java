import java.util.*;

public class Main {

    // ===== Node BST =====
    static class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    // ===== BST =====
    static class BST {
        private Node root;

        public void insert(int key) {
            root = insertRec(root, key);
        }

        private Node insertRec(Node node, int key) {
            if (node == null) return new Node(key);
            if (key < node.key) node.left = insertRec(node.left, key);
            else if (key > node.key) node.right = insertRec(node.right, key);
            // jika key sama, abaikan (atau bisa ditangani sesuai kebutuhan)
            return node;
        }

        public boolean contains(int key) {
            return containsRec(root, key);
        }

        private boolean containsRec(Node node, int key) {
            if (node == null) return false;
            if (key == node.key) return true;
            return key < node.key ? containsRec(node.left, key) : containsRec(node.right, key);
        }

        // ===== Traversal =====
        public List<Integer> inorder() {
            List<Integer> res = new ArrayList<>();
            inorderRec(root, res);
            return res;
        }
        private void inorderRec(Node node, List<Integer> res) {
            if (node == null) return;
            inorderRec(node.left, res);
            res.add(node.key);
            inorderRec(node.right, res);
        }

        public List<Integer> preorder() {
            List<Integer> res = new ArrayList<>();
            preorderRec(root, res);
            return res;
        }
        private void preorderRec(Node node, List<Integer> res) {
            if (node == null) return;
            res.add(node.key);
            preorderRec(node.left, res);
            preorderRec(node.right, res);
        }

        public List<Integer> postorder() {
            List<Integer> res = new ArrayList<>();
            postorderRec(root, res);
            return res;
        }
        private void postorderRec(Node node, List<Integer> res) {
            if (node == null) return;
            postorderRec(node.left, res);
            postorderRec(node.right, res);
            res.add(node.key);
        }

        // ===== Cetak struktur pohon (sideways) =====
        public void printTree() {
            if (root == null) {
                System.out.println("(empty)");
                return;
            }
            printTreeRec(root, "", true);
        }

        // print kanan → node → kiri (biar tampak "menyamping")
        private void printTreeRec(Node node, String prefix, boolean isTail) {
            if (node.right != null) {
                printTreeRec(node.right, prefix + (isTail ? "│   " : "    "), false);
            }
            System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.key);
            if (node.left != null) {
                printTreeRec(node.left, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    // ===== Demo sesuai poin (a) =====
    public static void main(String[] args) {
        int[] data = {10, 15, 21, 17, 19, 9, 23, 29, 4, 13};
        BST bst = new BST();

        for (int x : data) {
            bst.insert(x);
        }

        System.out.println("Struktur BST (sideways):");
        bst.printTree();

        System.out.println("\nInorder   (sorted):   " + bst.inorder());   // [4, 9, 10, 13, 15, 17, 19, 21, 23, 29]
        System.out.println("Preorder  (root,LR):  " + bst.preorder());  // [10, 9, 4, 15, 13, 21, 17, 19, 23, 29]
        System.out.println("Postorder (LR,root):  " + bst.postorder()); // [4, 9, 13, 19, 17, 29, 23, 21, 15, 10]

        // Contoh pengecekan
        System.out.println("\nContains 17? " + bst.contains(17)); // true
        System.out.println("Contains 8?  " + bst.contains(8));  // false
    }
}
