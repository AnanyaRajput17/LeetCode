/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
       ArrayList<Integer> list = new ArrayList<>();
       inorder(root,list);
       int sum = 0;
       for(Integer x:list){
        if(x>=low && x<=high){
            sum+=x;
        }
       }
       return sum;

    }
    public void  inorder (TreeNode root,ArrayList<Integer> list){
        
            if(root== null)return ;
            inorder(root.left , list);
            list.add(root.val);
            inorder(root.right , list);
         
         
    }
}