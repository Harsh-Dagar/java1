package BackTracking;

public class NQueen {
    public static void placeNQueens(int n){
        int arr[][]=new int[n][n];
        placeQueens(n,0,arr);

    }
    private static boolean isSafe(int arr[][],int i,int j){
        int n=arr.length;
        for(int x=j;x>=0;x--){
            if(arr[i][x]==1){
                return false;
            }
        }

        for(int x=i,y=j ;x>=0&&y>=0;x--,y--){
                if(arr[x][y]==1){
                    return false;
                }
        }
        for(int x=i,y=j ;x<n&&y>=0;x++,y--){
            if(arr[x][y]==1){
                return false;
            }
    }

        return true;
     
    }
    private static void placeQueens(int n,int c,int arr[][]){
        if(c==n){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int i=0;i<n;i++){
            if(isSafe(arr,i,c)){
                arr[i][c]=1;
                placeQueens(n, c+1, arr);
                //backtrack
                arr[i][c]=0;
            }
        }
    }
    public static void main(String[] args) {
        placeNQueens(5);
    }
}
