package Trees;

public class SumRootToLeafNumbers {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return res;
    }

    private void preorder(TreeNode root, int num){
        num *= 10;
        num += root.val;

        if(root.left == null && root.right == null){
            res += num;
            return;
        }

        if(root.left != null) preorder(root.left, num);
        if(root.right != null) preorder(root.right, num);
    }
}
