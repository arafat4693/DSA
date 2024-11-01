package Graphs;

public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length+1;
        UF uf = new UF(n*n);

        for(int i = 0; i < n-1; i++){
            uf.union(i, i+1);
            uf.union((n-1)*n+i, (n-1)*n+i+1);
            uf.union(n*i, n*i+n);
            uf.union(n*i+(n-1), n*i+(n-1)+n);
        }

        int regions = 1;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                char c = grid[i].charAt(j);
                int p1 = i*n+j, p2 = (i+1)*n+j;

                if(c == '/' && !uf.union(p1+1, p2)) regions++;
                else if(c == '\\' && !uf.union(p1, p2+1)) regions++;
            }
        }

        return regions;
    }
}
