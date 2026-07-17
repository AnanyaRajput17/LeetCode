class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for(int num : nums){
            max = Math.max(num , max);
        }
        long[] count = new long[max+1];
        for(int num : nums){
            count[num]++;
        }

        long[] gcount = new long[max+1];
        for(int i = 1;i<=max;i++){
            for(int j = i;j<=max;j+=i){
                gcount[i]+=count[j];
            }
        }
        long[] gcdcount = new long[max+1];

        for(int i = max ;i>=1;i--){
            gcdcount[i] = gcount[i] * (gcount[i]-1)/2;
            for(int j = i*2;j<=max;j+=i){
                gcdcount[i]-=gcdcount[j];
            }
        }
        long[] prefix = new long[max+1];
        for(int i = 1;i<=max;i++){
            prefix[i]=prefix[i-1]+gcdcount[i];
        }
        int[] ans = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            long target = queries[i]+1;
            int left = 1 ;
            int right = max;
            while(left<right){
                int mid = left + (right-left)/2;
                if(prefix[mid]>=target)
                right = mid;
                else{
                    left = mid+1;
                }
            }
            ans[i]= left;
        }
        return ans;
    }
}