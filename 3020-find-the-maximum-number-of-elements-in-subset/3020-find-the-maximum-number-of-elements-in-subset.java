class Solution {
    public int maximumLength(int[] nums) {
        Map<Long,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put((long)num , freq.getOrDefault((long)num,0)+1);
        }
        int ans = 1;
        if(freq.containsKey(1L)){
            int cnt = freq.get(1L);
            if(cnt%2==0){
                cnt--;
            }
            ans = Math.max(ans,cnt);
        }
        for(long num : freq.keySet()){
            if(num==1L) continue;
            long cur = num;
            int len = 0;
            while(freq.containsKey(cur)){
                if(freq.get(cur)>=2){
                    len+=2;
                    cur= cur*cur;
                }
                else{
                    len++;
                    break;
                }
            }
            if((len&1)==0)len--;
            ans = Math.max(ans,len);
        }
        return ans;
       
    }
}