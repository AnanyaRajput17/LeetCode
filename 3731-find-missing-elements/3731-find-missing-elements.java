class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0];
        int max = nums[n-1];
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<n;i++){
            list.add(nums[i]);
            }
        List<Integer> list2 = new ArrayList<>();    
        for(int j =min;j<=max;j++){
            if(!list.contains(j)){
                list2.add(j);
            }
        }
       return list2; 
    }
}