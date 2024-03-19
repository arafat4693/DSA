package Trees;

public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        int[] res = new int[1];
        dfs(root, root.val, res);
        return res[0];
    }

    private void dfs(TreeNode root, int maxByFar, int[] res){
        if(root == null) return;
        if(root.val >= maxByFar){
            maxByFar = root.val;
            res[0]++;
        }
        dfs(root.right, maxByFar, res);
        dfs(root.left, maxByFar, res);
    }
}
