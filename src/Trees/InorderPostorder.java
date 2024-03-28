package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();

        for(int i : inorder) inorderList.add(i);
        for(int p : postorder) postorderList.add(p);

        return buildTree(inorderList, postorderList);
    }

    public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder){
        if(inorder.isEmpty() || postorder.isEmpty()) return null;

        TreeNode root = new TreeNode(postorder.get(postorder.size()-1));

        int rootIdx = inorder.indexOf(root.val);

        root.left = buildTree(inorder.subList(0, rootIdx), postorder.subList(0, rootIdx));
        root.right = buildTree(inorder.subList(rootIdx+1, inorder.size()), postorder.subList(rootIdx, postorder.size()-1));

        return root;
    }
}
