package BackTracking;

public class RatInAMaze {
    public static boolean ratInMaze(int maze[][]) {
        int n = maze.length;
        int m = maze[0].length;
        int path[][] = new int[n][m];
        return findPath(maze, path, 0, 0);
    }

    private static boolean findPath(int maze[][], int path[][], int i, int j) {
        int n = maze.length;
        int m = maze[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || maze[i][j] == 0 || path[i][j] == 1)
            return false;

        path[i][j] = 1;
        if (i == n - 1 && j == m - 1) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            return true;
        }

        // top
        if (findPath(maze, path, i - 1, j)) {
            return true;
        }

        // right
        if (findPath(maze, path, i, j + 1)) {
            return true;
        }

        // down
        if (findPath(maze, path, i + 1, j)) {
            return true;
        }

        // left
        if (findPath(maze, path, i, j - 1)) {
            return true;
        }

        return false;
    }


	static void printAllPath(int maze[][], int n) {
		/* 
			* Your class should be named Solution.
			* Write your code here
		 */
        int path[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                path[i][j]=0;
            }
        }
        
        printPath(n,maze,0,0,path);
        
	}
    private static void printPath(int n,int maze[][],int i,int j,int path[][]){
        if(i<0||i>=n||j<0||j>=n||maze[i][j]==0||path[i][j]==1){
            return;
        }
        path[i][j]=1;
        if(i==n-1&&j==n-1){
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    System.out.print(path[r][c]+" ");
                }
            }
            System.out.println();
            path[i][j]=0;
            return;
        }
        printPath(n,maze,i-1,j,path);
        printPath(n,maze,i,j+1,path);   
        printPath(n,maze,i+1,j,path);   
        printPath(n,maze,i,j-1,path);
        path[i][j]=0;
        
    }
}