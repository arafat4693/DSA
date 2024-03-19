package Trees;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        if(sameTree(root, subRoot)) return true;
        if(isSubtree(root.left, subRoot)) return true;
        return isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null || s.val != t.val) return false;

        return sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }
}
