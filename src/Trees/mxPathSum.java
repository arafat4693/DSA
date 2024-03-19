package Trees;

public class mxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int leftSum = Math.max(dfs(root.left), 0);
        int rightSum = Math.max(dfs(root.right),0);
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
