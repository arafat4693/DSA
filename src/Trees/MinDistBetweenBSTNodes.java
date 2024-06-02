package Trees;

public class MinDistBetweenBSTNodes {
    // List<Integer> arr = new ArrayList<>();

    // public int minDiffInBST(TreeNode root) {
    //     inorder(root);
    //     int min = Integer.MAX_VALUE;
    //     for(int i = 0; i < arr.size()-1; i++){
    //         min = Math.min(min, arr.get(i+1)-arr.get(i));
    //     }
    //     return min;
    // }

    // private void inorder(TreeNode node){
    //     if(node == null) return;
    //     inorder(node.left);
    //     arr.add(node.val);
    //     inorder(node.right);
    // }

    int res = Integer.MAX_VALUE, prev = -1;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode node){
        if(node == null) return;

        inorder(node.left);
        if(prev != -1) res = Math.min(res, node.val - prev);
        prev = node.val;
        inorder(node.right);
    }
}
