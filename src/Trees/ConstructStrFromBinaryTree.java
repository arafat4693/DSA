package Trees;

public class ConstructStrFromBinaryTree {
    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root, res);
        res.deleteCharAt(0);
        res.deleteCharAt(res.length()-1);

        return res.toString();
    }

    private void dfs(TreeNode node, StringBuilder res){
        if(node == null) {
            res.append("()");
            return;
        }

        res.append('(').append(node.val);

        dfs(node.left, res);
        dfs(node.right, res);

        if(node.left == null && node.right == null){
            res.delete(res.length()-4, res.length());
        }else if(node.left != null && node.right == null){
            res.delete(res.length()-2, res.length());
        }

        res.append(')');
    }
}
