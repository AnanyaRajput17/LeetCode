class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list2 = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        int[] row = new int[n];
        Arrays.fill(row, 0);
        int[] lowerdia = new int[2*n-1];
        Arrays.fill(lowerdia , 0);
        int[] upperdia = new int[2*n-1];
        Arrays.fill(upperdia , 0);
        solve(0,n,row,upperdia,lowerdia,board,list2);

        return list2;
        
    }

    public void solve(int col,int n,int[] row,int[] upperdia ,int[] lowerdia, char[][] board , List<List<String>> list2){
        if(col==n){
            list2.add(convert(board));
            return;
        }
        for(int i = 0;i<n;i++){
            if(row[i]==0 && upperdia[n-1+col-i]==0 && lowerdia[i+col]==0){
                board[i][col]='Q';
                row[i] = 1;
                lowerdia[i+col]=1;
                upperdia[n-1+col-i]=1;
                solve(col+1,n,row,upperdia,lowerdia,board,list2);
                board[i][col]='.';
                row[i] = 0;
                lowerdia[i+col]=0;
                upperdia[n-1+col-i]=0;
            }
        }
    }
    public List<String> convert (char[][] board){
        List<String> list = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
           
            list.add(new String(board[i]));
        }
        return list;
    }
}