package Test;

public class upp8 <E extends Comparable<E>>{

    private static class Node<E> {
        private E data;
        private Node<E> left, right;
        private Node(E d) {
            data = d;
            left = right = null;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }


    private Node<E> root;

    public upp8() {
        root = null;
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            inOrder(node.right, sb);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<E>(data);
                return true;
            } else {
                return add(data, node.left);
            }
        } else if (node.right == null) {
            node.right = new Node<E>(data);
            return true;
        } else {
            return add(data, node.right);
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true;
        } else {
            return add(data, root);
        }
    }
//    public E getNextLarger(E element) {
//
//        Node<E> current = root;
//        E bestSoFar = null;
//
//        while (current != null) {
//            if (element.compareTo(current.data) < 0) {
//                bestSoFar = current.data;
//                current = current.left;
//            }
//            else if (element.compareTo(current.data) >= 0 ) {
//                current = current.right;
//            }
//        }
//        return bestSoFar;
//    }


    public E getNextLarger(E element){
        return getNextLarger(element, root);
    }

    private E getNextLarger(E element, Node<E> node){
        if(node == null) return null;

        if(element.compareTo(node.data) < 0){
            E nextLarger = getNextLarger(element, node.left);
            return nextLarger == null ? node.data : nextLarger;
        }

        return getNextLarger(element, node.right);
    }
}
