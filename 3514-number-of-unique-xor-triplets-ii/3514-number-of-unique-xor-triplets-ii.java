class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int maxElement = 0;
        for(int num:nums){
            maxElement = Math.max(num,maxElement);
        }
        int size = 1;
        while(size<=maxElement){
            size<<=1;
        }
        boolean[] two = new boolean[size];
        // Arrays.fill(two,false);
        boolean[] three = new boolean[size];
        // Arrays.fill(three,false);
        for(int i =0;i<n;i++){
            for(int j = i;j<n;j++){
                int xor = nums[i]^nums[j];
                if(two[xor]==false){
                    two[xor]=true;
                }
            }
        }
        for(int i = 0;i<size;i++){
            if(two[i]==true){
                for(int num:nums){
                    int xor =num^i;
                    three[xor]=true;
                }
            }

        }
        int count=0;
        for(int k = 0;k<size;k++){
            if(three[k]==true){
                count++;
            }
        }
        return count;
    }
}