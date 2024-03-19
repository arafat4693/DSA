package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructIPreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // pre: root left-subtree right-subtree
        // in: left-subtree root right-subtree

        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();

        for(int i = 0; i < preorder.length; i++){
            preList.add(preorder[i]);
            inList.add(inorder[i]);
        }

        return buildTree(preList, inList);
    }

    private TreeNode buildTree(List<Integer> preorder, List<Integer> inorder){
        if(preorder.isEmpty() || inorder.isEmpty()) return null;

        TreeNode root = new TreeNode();
        root.val = preorder.get(0);
        int rootIdx = inorder.indexOf(root.val);
        root.left = buildTree(preorder.subList(1, rootIdx+1), inorder.subList(0, rootIdx));
        root.right = buildTree(preorder.subList(rootIdx+1, preorder.size()), inorder.subList(rootIdx+1, inorder.size()));

        return root;
    }
}
