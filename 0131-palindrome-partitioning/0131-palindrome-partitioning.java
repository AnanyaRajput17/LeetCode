class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list2 = new ArrayList<>();
        List<String> list = new ArrayList<>();
        check(0,s,list,list2);
        return list2;
    }
    public void check(int index , String s ,List<String> list,List<List<String>> list2){
        if(index == s.length()){
                list2.add(new ArrayList<>(list));
                return ;
            }
            for(int i = index ; i<s.length(); ++i){
                if(palindrome(s,index,i)){
                    list.add(s.substring(index,i+1));
                    check(i+1,s,list,list2);
                    list.remove(list.size()-1);
                }
            }
    }
    public boolean palindrome(String s , int start , int end){
       while(start<=end){
        if(s.charAt(start)!=s.charAt(end)) return false;
        start++;
        end--;
       }
       return true;
    }
}