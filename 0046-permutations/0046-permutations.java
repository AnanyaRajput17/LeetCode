class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        boolean[] freq = new boolean[n];
        permutate(nums,list , list2,freq);
        return list2;
    }
    public void permutate(int[] nums ,List<Integer> list ,List<List<Integer>> list2 ,boolean[] freq){
        if(list.size()==nums.length){
            list2.add(new ArrayList<>(list));
        }
        for(int i = 0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                list.add(nums[i]);
                permutate(nums,list,list2,freq);
                list.remove(list.size()-1);
                freq[i]=false;
            }
        }

    }
}