package Graphs.Assignment;

public class CodingNinjasPresent {
    String str = "CODINGNINJAS";
    private int a[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };

    private boolean valid(int n, int m, int x, int y) {
        if (x >= 0 && x<n && y>=0 && y<m) {
            return true;
        }
        return false;
    }

    private int DFS(String[] graph, int n, int m, boolean[][] visited, int x, int y, int index) {
        if (index == 11)
            return 1;

        int found = 0;
        visited[x][y] = true;
        int newX;
        int newY;
        for (int i = 0; i < 8; i++) {
            newX = x + a[i][0];
            newY = y + a[i][1];
            if (valid(n, m, newX, newY) && graph[newX].charAt(newY) == str.charAt(index) && !visited[newX][newY])
                found = found | DFS(graph, n, m, visited, newX, newY, index + 1);
        }
        visited[x][y] = false;
        return found;
    }

    public int solve(String[] graph, int n, int m) {
        boolean[][] visited = new boolean[n][m];

        int found = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i].charAt(j) == 'C')
                    found = DFS(graph, n, m, visited, i, j, 1);
                if(found==1){
                    break;
                }
            }
            if(found==1){
                break;
            }
        }
        return found;
    }
}