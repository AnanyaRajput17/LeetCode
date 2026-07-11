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
 class Node{
    TreeNode node;
    int index;
    Node(TreeNode node , int index){
        this.node = node;
        this.index= index;

    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().index;
           
            int first = 0,last = 0;
            for(int i = 0;i<size;i++){
                int cur_id = queue.peek().index - min;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
                if(node.left!=null) queue.offer(new Node(node.left , cur_id*2+1));
                if(node.right!=null) queue.offer(new Node(node.right , cur_id*2+2));
                
            }
            ans = Math.max(ans , last-first+1);
        }

        return ans;
    }
}