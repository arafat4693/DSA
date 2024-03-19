package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BTrightSideView {
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if(root == null) return res;
//        Deque<TreeNode> dq = new ArrayDeque<>();
//
//        dq.addFirst(root);
//
//        while(!dq.isEmpty()){
//            int qLen = dq.size();
//            for(int i = 0; i < qLen; i++){
//                if(dq.peekFirst().right != null) dq.addLast(dq.peekFirst().right);
//                if(dq.peekFirst().left != null) dq.addLast(dq.peekFirst().left);
//                if(i == 0) res.add(dq.pollFirst().val);
//                else dq.pollFirst();
//            }
//        }
//
//        return res;
//    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> res){
        if(root == null) return;
        if(level == res.size()) res.add(root.val);
        dfs(root.right, level + 1, res);
        dfs(root.left, level + 1, res);
    }
}
