package Trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElms {
//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> res = new ArrayList<>();
//        inorder(root, res);
//        return res.get(k-1);
//    }
//
//    private void inorder(TreeNode root, List<Integer> res){
//        if(root == null) return;
//        inorder(root.left, res);
//        res.add(root.val);
//        inorder(root.right, res);
//    }

    public int kthSmallest(TreeNode root, int k) {
        Pair data = new Pair();
        inorder(root, k, data);
        return data.res;
    }

    private void inorder(TreeNode root, int k, Pair data){
        if(root == null || data.count >= k) return;

        inorder(root.left, k, data);
        if(++data.count == k) data.res = root.val;
        inorder(root.right, k, data);
    }

    class Pair {
        int count = 0;
        int res = -1;
    }
}
