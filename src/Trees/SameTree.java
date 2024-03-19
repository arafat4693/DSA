package Trees;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;

        boolean left = isSameTree(p.left, q.left);
        if(!left) return false;
        boolean right = isSameTree(p.right, q.right);
        if(!right) return false;

        return p.val == q.val;
    }
}
