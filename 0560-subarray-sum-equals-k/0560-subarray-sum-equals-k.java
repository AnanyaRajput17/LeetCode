import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        
        // Map stores: <PrefixSum, Frequency>
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        
        // Base case: a prefix sum of 0 occurs once (empty subarray before index 0)
        prefixSumCount.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - k) has been seen before
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            
            // Record the current prefix sum in the map
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}