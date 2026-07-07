class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int i = 1;
        while(n>0){
            int digit = n%10;
           if(digit!=0)
            {
                x= x + digit*i;
                i*=10;
                
            }
            n = n/10;
           

        }
        int sum = 0;
        int x1 = x;
        while(x1>0){
            sum+= x1%10 ;
           
            x1= x1/10;
        }
        return (long)x*sum;
        
    }
}