package kthdsa.F7;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
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

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Trädet är tomt.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(0);

        int currentLevel = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int level = levels.poll();

            if (level > currentLevel) {
                System.out.println();
                currentLevel = level;
            }

            if (current == null)
                System.out.print("null ");
            else {
                System.out.print(current.data + " ");
                queue.add(current.left);
                queue.add(current.right);
                levels.add(level + 1);
                levels.add(level + 1);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        String[] words = {"H", "B", "N", "A", "E", "C", "F", "D"};

        for (String word : words) {
            bst.insert(word);
        }

        System.out.println("Trädet:");
        bst.printTree();
    }
}


