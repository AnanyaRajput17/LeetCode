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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        TreeNode cur = root;
        if(root.val==key) return helper(root);
        TreeNode curr = root;
        while(root!=null){
            if(root.val<key){
               if(root.right!=null && root.right.val ==key){
                root.right = helper(root.right);
                break;
               }
               else{
                root = root.right;
               }
            }
            else{
                if(root.left!=null && root.left.val ==key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
        }
    
    return curr;
}
    public TreeNode helper(TreeNode node){
        if(node.left==null)return node.right;
        if(node.right==null)return node.left;
        TreeNode n1 = node.right;
        TreeNode n2 = find(node.left);
        n2.right = n1;
        return node.left;

    }
    public TreeNode find(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
}