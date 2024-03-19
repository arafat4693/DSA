package Trees;

import java.util.Arrays;
import java.util.List;

public class EncodeAndDecode {
    int idx = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        preOrder(root, s);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> dataList = Arrays.asList(data.split(","));
        System.out.println(dataList);
        return decode(dataList);
    }

    private TreeNode decode(List<String> dataList){
        if(dataList.get(idx).equals("N")){
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(idx)));
        idx++;
        root.left = decode(dataList);
        root.right = decode(dataList);
        return root;
    }

    private void preOrder(TreeNode root, StringBuilder s){
        if(root == null) {
            if(s.isEmpty()) s.append("N");
            else s.append(',').append("N");
            return;
        };
        if(s.isEmpty()){
            s.append(root.val);
        }else s.append(',').append(root.val);
        preOrder(root.left, s);
        preOrder(root.right, s);
    }
}
