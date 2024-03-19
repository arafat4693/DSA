package Trees;

public class BalanceTree {
    public boolean isBalanced(TreeNode root) {
        return isBalance(root) != Integer.MAX_VALUE;
    }

    private int isBalance(TreeNode root){
        if(root == null) return 0;

        int left = isBalance(root.left);
        if(left == Integer.MAX_VALUE) return left;

        int right = isBalance(root.right);
        if(right == Integer.MAX_VALUE) return right;

        if(Math.abs(left - right) <= 1) return (1+Math.max(left, right));
        else return Integer.MAX_VALUE;
    }
}
