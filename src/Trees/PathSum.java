package Trees;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int total) {
        if(root.left == null && root.right == null) return targetSum == total+root.val;

        boolean ans = false;

        if(root.left != null) ans = dfs(root.left, targetSum, total+root.val);
        if(!ans && root.right != null) ans = dfs(root.right, targetSum, total+root.val);

        return ans;
    }
}
