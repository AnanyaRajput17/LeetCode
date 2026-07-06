class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b)->{
           if(a[0]!=b[0])
               return a[0]-b[0];
           return b[1]-a[1];
    });
           int count = 0;
           int first = intervals[0][0];
           int second = intervals[0][1];
           for(int i = 1;i<intervals.length;i++){
            if(first==intervals[i][0] || second>= intervals[i][1])
            count++;
           
           else{
            first = intervals[i][0];
            second = intervals[i][1];
           }
           }
           return intervals.length-count;

    }
}