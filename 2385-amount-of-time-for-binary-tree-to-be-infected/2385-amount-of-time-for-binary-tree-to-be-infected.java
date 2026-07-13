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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode , TreeNode> parent = new HashMap<>();
        TreeNode node= parent(parent ,root,start);
        
        int time = 0;
        Map<TreeNode , Boolean> infected = new HashMap<>();
        infected.put(node,true);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean newinfected = false;
            
            for(int i =0;i<size;i++){
                
                TreeNode n2 = queue.poll();
                if(n2.left!=null&& infected.get(n2.left)== null){
                    infected.put(n2.left , true);
                    queue.offer(n2.left);
                    newinfected = true;
                }
                 if(n2.right!=null&& infected.get(n2.right)== null){
                    infected.put(n2.right , true);
                    queue.offer(n2.right);
                    newinfected = true;
                }
                 if(parent.get(n2)!=null&& infected.get(parent.get(n2))== null){
                    infected.put(parent.get(n2) , true);
                    queue.offer(parent.get(n2));
                    newinfected = true;
                }
            }
            if(newinfected) time++;

        }
        return time;
        
    }
    public TreeNode parent(Map<TreeNode,TreeNode> parent , TreeNode root , int start){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;
        while(!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            if(n1.val== start) node = n1;
            if(n1.left!=null){
                parent.put(n1.left,n1);
                queue.offer(n1.left);
            }
             if(n1.right!=null){
                parent.put(n1.right,n1);
                queue.offer(n1.right);
            }
        }
        return node;
    }
}