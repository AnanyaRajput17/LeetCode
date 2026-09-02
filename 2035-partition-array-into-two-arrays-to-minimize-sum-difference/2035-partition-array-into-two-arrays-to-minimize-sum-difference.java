class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int x : nums) sum+=x;
        int n1 = n/2;
        int n2 = n-n1;
        Map<Integer , List<Integer>> leftmap = new HashMap<>();
        Map<Integer , List<Integer>> rightmap = new HashMap<>();
        for(int mask = 0;mask< (1<<n1);mask++){
            int count = 0;
            int s = 0;
            for(int i = 0;i<n1 ;i++){
                if((mask & (1<<i))!=0){
                    s+=nums[i];
                    count++;
                }
            }
            leftmap.computeIfAbsent(count , key-> new ArrayList<>()).add(s);

        }
         for(int mask = 0;mask< (1<<n2);mask++){
            int count = 0;
            int s = 0;
            for(int i = 0;i<n2 ;i++){
                if((mask & (1<<i))!=0){
                    s+=nums[i+n2];
                    count++;
                }
            }
            rightmap.computeIfAbsent(count , key-> new ArrayList<>()).add(s);
            
        }
        for(int count = 0;count<=n2;count++){
            Collections.sort(rightmap.computeIfAbsent(count , key->new ArrayList<>()));
        }
        int minvalue = Integer.MAX_VALUE;
        for(int k = 0;k<=n1;k++){
            int m = n1 - k;
            List<Integer> left = leftmap.getOrDefault(k , new ArrayList<>());
            for(int leftsum : left){
                int need = (sum - 2*leftsum)/2;
                List<Integer> right = rightmap.getOrDefault(m , new ArrayList<>());
                int low = lowerbound(need , right);
                if(low<right.size()){
                    int rightsum = right.get(low);
                    minvalue = Math.min(minvalue , Math.abs(2*(leftsum + rightsum)-sum));
                }
                if(low-1>=0){
                   int rightsum = right.get(low-1);
                    minvalue = Math.min(minvalue , Math.abs(2*(leftsum + rightsum)-sum));
                }
            }
        }

        return minvalue;
    }
    public int lowerbound(int need , List<Integer> right){
        int low = 0;
        int high = right.size();
        while(low<high){
            int mid = low +(high-low)/2;
            if(right.get(mid)<need) low = mid+1;
            else{
                high = mid;
            }
            
        }
        return low;
    }
}