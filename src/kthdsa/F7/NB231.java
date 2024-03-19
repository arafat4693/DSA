package kthdsa.F7;

import java.util.LinkedList;
import java.util.Queue;

public class NB231 {
    private Node root;

    public NB231() {
        root = null;
    }

    public void insert(String data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, String data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);

        return root;
    }

    public int numberOfLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public int numberOfNodes() {
        return countNodes(root);
    }

    private int countNodes(Node root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int height() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node root) {
        if (root == null)
            return -1;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        NB231 bst = new NB231();
        String[] words = {"H", "B", "N", "A", "E", "C", "F", "D"};

        for (String word : words) {
            bst.insert(word);
        }

        System.out.println("Antal löv: " + bst.numberOfLeaves());
        System.out.println("Antal noder: " + bst.numberOfNodes());
        System.out.println("Höjd på trädet: " + bst.height());
    }
}

