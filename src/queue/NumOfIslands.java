package queue;

public class NumOfIslands {
    public static void main(String[] args) {
    char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    System.out.println(numOfIslands(grid));
    }

    public static int numOfIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int count = 0;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (i<0 || j<0 || i>grid.length || j>=grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
    }
}
