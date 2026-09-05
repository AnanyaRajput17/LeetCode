import java.util.*;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        
        // Split lengths safely for odd/even arrays
        int leftLen = n / 2;
        int rightLen = n - leftLen;
        
        Map<Integer, List<Integer>> leftmap = new HashMap<>();
        Map<Integer, List<Integer>> rightmap = new HashMap<>();
        
        // 1. Generate all subsets for the LEFT half
        for (int mask = 0; mask < (1 << leftLen); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < leftLen; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                    count++;
                }
            }
            leftmap.computeIfAbsent(count, k -> new ArrayList<>()).add(sum);
        }
        
        // 2. Generate all subsets for the RIGHT half
        for (int mask = 0; mask < (1 << rightLen); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < rightLen; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[leftLen + i]; // Offset index by leftLen
                    count++;
                }
            }
            rightmap.computeIfAbsent(count, k -> new ArrayList<>()).add(sum);
        }
        
        // 3. Sort the right map lists for Binary Search
        for (int count = 0; count <= rightLen; count++) {
            List<Integer> list = rightmap.get(count);
            if (list != null) {
                Collections.sort(list);
            }
        }
        
        // 4. Match left subsets with right subsets
        for (int leftCount = 0; leftCount <= leftLen; leftCount++) {
            List<Integer> leftList = leftmap.get(leftCount);
            if (leftList == null) continue;
            
            for (int rightCount = 0; rightCount <= rightLen; rightCount++) {
                int totalCount = leftCount + rightCount;
                
                // The subset cannot be empty (0) and cannot be the whole array (n)
                if (totalCount == 0 || totalCount == n) continue;
                
                // The target sum for this totalCount must be a perfect integer
                if ((totalSum * totalCount) % n != 0) continue;
                
                int targetTotalSum = (totalSum * totalCount) / n;
                
                for (int leftSum : leftList) {
                    int rightSum = targetTotalSum - leftSum;
                    
                    if (binarysearch(rightSum, rightCount, rightmap)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

  
    public boolean binarysearch(int target, int count, Map<Integer, List<Integer>> rightmap) {
        List<Integer> list = rightmap.get(count);
        if (list == null) return false;
        
        int low = 0;
        int high = list.size() - 1; 
        
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            int midVal = list.get(mid);
            
            if (midVal == target) return true;
            if (midVal < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}