package Trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTs2 {
    public List<TreeNode> generateTrees(int n) {
        return backtrack(1, n, n);
    }

    private List<TreeNode> backtrack(int start, int end, int n){
        List<TreeNode> trees = new ArrayList<>();

        if(end < start){
            trees.add(null);
            return trees;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> left = backtrack(start, i-1, n);
            List<TreeNode> right = backtrack(i+1, end, n);

            for(TreeNode leftNode : left){
                for(TreeNode rightNode : right){
                    trees.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }

        return trees;
    }
}
