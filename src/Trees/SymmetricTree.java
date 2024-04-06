package Trees;

import java.util.*;

public class SymmetricTree {
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//
//        while(!q.isEmpty()){
//            Deque<Integer> dq = new ArrayDeque<>();
//
//            int size = q.size();
//            for(int i = 0; i < size; i++){
//                TreeNode node = q.poll();
//                if(node == null) continue;
//                q.add(node.left);
//                q.add(node.right);
//
//                dq.add(node.left == null ? -200 : node.left.val);
//                dq.add(node.right == null ? -200 : node.right.val);
//            }
//
//            while(!dq.isEmpty()){
//                if(!Objects.equals(dq.pollFirst(), dq.pollLast())) return false;
//            }
//        }
//
//        return true;
//    }

    public boolean isSymmetric(TreeNode root){
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode leftTree, TreeNode rightTree){
        if(leftTree == null && rightTree == null) return true;
        if(leftTree == null || rightTree == null) return false;
        return leftTree.val == rightTree.val && dfs(leftTree.left, rightTree.right) && dfs(leftTree.right, rightTree.left);
    }
}
