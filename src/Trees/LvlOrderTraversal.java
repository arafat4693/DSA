package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LvlOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.addFirst(root);

        while(!dq.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int qLen = dq.size();
            for(int i = 0; i < qLen; i++){
                if(dq.peek().left != null){
                    dq.addLast(dq.peek().left);
                }
                if(dq.peek().right != null){
                    dq.addLast(dq.peek().right);
                }

                level.add(dq.pollFirst().val);
            }
            res.add(level);
        }

        return res;
    }
}
