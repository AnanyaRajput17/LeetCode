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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = findhl(root);
        int rh = findhr(root);
        if(lh==rh) return (2<<(rh))-1;
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int findhl(TreeNode node){
        if(node==null) return 0;
        int h = 0;
        while(node.left!=null){
            h++;
            node = node.left;

        }
        return h;

    }
    public int findhr(TreeNode node){
        if(node==null) return 0;
        int h = 0;
        while(node.right!=null){
            h++;
            node = node.right;

        }
        return h;
        
    }
}