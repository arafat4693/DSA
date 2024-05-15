package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isNull = false;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node == null){
                    isNull = true;
                    continue;
                }
                if(isNull) return false;
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }
}
