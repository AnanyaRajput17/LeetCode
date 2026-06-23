class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod = (int)1e9+7;
        int k = r-l;
        int[][] dp = new int[n][k+1];
        int ans = 0;
        for(int i=0;i<=k;i++){
            dp[0][i]=1;
        }
        for(int i = 1;i<n;i++){
            if((i&1)== 1){
                int rs =0;
                for(int j = 0; j<=k;j++){
                    dp[i][j] = rs;
                    rs = (rs + dp[i-1][j]) % mod;
                }
            }
            else{
                int rs = 0;
                for(int j = k;j>=0;j--){
                    dp[i][j] = rs;
                    rs = (rs + dp[i-1][j]) % mod;
                }
            }

        }
        for(int i =0;i<=k;i++){
            ans = (ans + dp[n-1][i]) % mod;
        }
        return (int)(ans*2) % mod;
    }
}