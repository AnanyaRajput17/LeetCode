class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        permutate2(nums,list,list2,freq);
        return list2;
    }
    public void permutate2(int[] nums ,List<Integer> list,  List<List<Integer>> list2 , boolean[] freq){
        if(list.size()==nums.length){
            list2.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]&& !freq[i-1]) continue;
                if(!freq[i]){
                    freq[i]=true;
                    list.add(nums[i]);
                    permutate2(nums,list,list2,freq);
                    list.remove(list.size()-1);
                    freq[i]=false;
                }
            
        }
    }
}