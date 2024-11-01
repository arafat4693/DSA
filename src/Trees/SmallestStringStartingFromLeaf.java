package Trees;

public class SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode root, String res){
        String s = (char)('a'+root.val) + res;

        if(root.left == null && root.right == null) return s;

        if(root.right == null) return dfs(root.left, s);
        else if(root.left == null) return dfs(root.right, s);
        else{
            String left = dfs(root.left, s);
            String right = dfs(root.right, s);

            if(left.compareTo(right) < 0) return left;
            return right;
        }
    }
}
