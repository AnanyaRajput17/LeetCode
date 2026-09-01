import java.util.Arrays;

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int n1 = n / 2;
        int n2 = n - n1;
        
        int[] left = new int[1 << n1];
        int[] right = new int[1 << n2];
        
        
        for (int mask = 0; mask < (1 << n1); mask++) {
            int sum = 0;
            for (int i = 0; i < n1; i++) { 
                if ((mask & (1 << i)) != 0) { 
                    sum += nums[i];
                }
            }
            left[mask] = sum;
        }
        
       
        for (int mask = 0; mask < (1 << n2); mask++) {
            int sum = 0;
            for (int i = 0; i < n2; i++) { 
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i + n1];
                }
            }
            right[mask] = sum;
        }
        
        Arrays.sort(right);
        int minn = Integer.MAX_VALUE;
        
        
        for (int x : left) {
            int target = goal - x;
            int low = 0;
            int high = right.length - 1; 
            
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                
                
                int currentSum = x + right[mid];
                minn = Math.min(minn, Math.abs(goal - currentSum)); 
                
                if (right[mid] == target) {
                    return 0;
                } else if (right[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return minn;
    }
}