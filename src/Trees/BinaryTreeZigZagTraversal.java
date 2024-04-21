package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        boolean left = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subRes = new ArrayList<>(size);

            for(int i = 0; i < size; i++) subRes.add(0);

            for(int i = 0; i < size; i++){
                int idx = left ? i : (size-1-i);
                TreeNode node = q.poll();
                subRes.set(idx, node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            res.add(subRes);

            left = !left;
        }

        return res;
    }
}
