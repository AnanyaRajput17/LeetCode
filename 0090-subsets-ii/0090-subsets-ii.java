class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subset(0,nums,list2 , list);
        return list2;
    }
    public void subset(int index , int[] nums,List<List<Integer>> list2,List<Integer> list ){
       list2.add(new ArrayList<>(list));
        for(int i = index;i<nums.length;i++){
            if(i!=index&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            subset(i+1,nums,list2,list);
            list.remove(list.size()-1);
        }
    }
}