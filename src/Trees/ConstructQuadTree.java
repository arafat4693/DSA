package Trees;

public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length-1, 0, grid[0].length-1);
    }

    public Node construct(int[][] grid, int rs, int re, int cs, int ce){
        boolean isLeaf = true;
        int first = grid[rs][cs];

        for(int r = rs; r <= re; r++){
            for(int c = cs; c <= ce; c++){
                if(grid[r][c] != first) {
                    isLeaf = false;
                    break;
                }
            }
        }

        if(isLeaf){
            return new Node(first == 1, isLeaf);
        }

        Node root = new Node(true, isLeaf);

        int r = (rs+re)/2;
        int c = (cs+ce)/2;

        root.topLeft = construct(grid, rs, r, cs, c);
        System.out.println("val " + root.topLeft.val + " leaf " + root.topLeft.isLeaf);
        root.topRight = construct(grid, rs, r, c+1, ce);
        root.bottomLeft = construct(grid, r+1, re, cs, c);
        root.bottomRight = construct(grid, r+1, re, c+1, ce);

        return root;
    }
}
