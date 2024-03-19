package Trees;

import java.util.List;

public class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while(true){
            if(p.val > current.val && q.val > current.val){
                current = current.right;
            }else if(p.val < current.val && q.val < current.val){
                current = current.left;
            }else return current;
        }
    }
}
