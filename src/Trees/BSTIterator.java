package Trees;

import java.util.Stack;

public class BSTIterator {
//    private Stack<Integer> st;
//
//    public BSTIterator(TreeNode root) {
//        this.st = new Stack<>();
//        inorder(root);
//    }
//
//    public int next() {
//        return st.pop();
//    }
//
//    public boolean hasNext() {
//        return !st.isEmpty();
//    }
//
//    private void inorder(TreeNode node){
//        if(node == null) return;
//        inorder(node.right);
//        st.push(node.val);
//        inorder(node.left);
//    }

    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        fill(root);
    }

    public int next() {
        TreeNode top = st.pop();
        if(top.right != null){
            fill(top.right);
        }
        return top.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void fill(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}
