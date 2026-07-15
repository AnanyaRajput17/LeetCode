class Solution {
    public int gcdOfOddEvenSums(int n) {
        int seven = 2;
        int sodd = 1;
        int even = 2;
        int odd = 1;
        for(int i =0;i<n;i++){
            even+=2;
            seven+=even;
            odd+=2;
            sodd+=odd;
            
        }
        return gcd(seven,sodd);
        
    }
    public int gcd(int a , int b){
        int gcd = 1;
        for(int i =2;i<=Math.min(a,b);i++){
            if(a%i==0 && b%i==0){
                gcd = i;
            }
        }
        return gcd-1;
    }
}