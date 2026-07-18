class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x : nums){
            min = Math.min(x, min);
            max = Math.max(x,max);
        }
        return gcd(min , max);
        
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