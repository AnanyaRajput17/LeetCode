class Solution {
    public int smallestNumber(int n, int t) {
        int ans =0;
        for(int i=n;i<n+t;i++){
            if(product(i)%t==0){
                ans=i;
                break;
            }
        }
        return ans;
    }
    public int product (int n){
        int product=1;
        while(n>0){
            int digit = n%10;
            product*=digit;
            n=n/10;
        }
        return product;
    }
}