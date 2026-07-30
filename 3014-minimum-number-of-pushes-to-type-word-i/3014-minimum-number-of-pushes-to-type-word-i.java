class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int totalpushes=0;
        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;
            int rank = 25-i;
            int push = (rank/8)+1;
            totalpushes+=freq[i]*push;
        }
        return totalpushes;
    }
}