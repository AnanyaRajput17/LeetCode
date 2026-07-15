class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sodd=n*n;
        int seven = n*(n-1);
        return gcd(seven,sodd);
        
    }
    public int gcd(int a , int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}