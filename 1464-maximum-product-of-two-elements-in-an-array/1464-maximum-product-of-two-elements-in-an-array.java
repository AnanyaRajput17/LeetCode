class Solution {
    public int maxProduct(int[] nums) {
        int max1=0;
        int max2=0;
        for(int i = 0;i<nums.length;i++){
            int digit=nums[i];
            if(digit>max1){
                max2=max1;
                max1=digit;
            }
            else if(digit>max2){
                max2=digit;
            }
        }
        return (max1-1)*(max2-1);
    }
}