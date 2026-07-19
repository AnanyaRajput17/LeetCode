class Solution {
    public String smallestSubsequence(String s) {
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder(); 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--; 
            
         
            if (visited[c - 'a']) {
                continue;
            }
            
            
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                char removed = sb.charAt(sb.length() - 1);
                visited[removed - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            
           
            sb.append(c);
            visited[c - 'a'] = true;
        }
        
        return sb.toString();
    }
}