package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        return nodes;
    }

    private void inorderTraversal(TreeNode node, List<Integer> nodes){
        if(node == null) return;
        inorderTraversal(node.left, nodes);
        nodes.add(node.val);
        inorderTraversal(node.right, nodes);
    }
}
