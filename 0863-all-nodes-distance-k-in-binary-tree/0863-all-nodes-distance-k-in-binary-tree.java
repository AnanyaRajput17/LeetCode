/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parent = new HashMap<>();
        parent(root,parent);
        Map<TreeNode , Boolean> visited = new HashMap<>();
        int distance = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        visited.put(target,true);
        queue.offer(target);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(distance==k) break;
            distance+=1;
            for(int i = 0;i<size;i++){
                TreeNode current = queue.poll();
                if(current.left!=null && visited.get(current.left)== null){
                    queue.offer(current.left);
                    visited.put(current.left,true);

                }
                if(current.right!=null && visited.get(current.right)== null){
                    queue.offer(current.right);
                    visited.put(current.right,true);
                    
                }
                if(parent.get(current)!=null && visited.get(parent.get(current))== null){
                    queue.offer(parent.get(current));
                    visited.put(parent.get(current),true);
                    
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            list.add(current.val);
        }
        return list;


    }
    public void parent(TreeNode root , Map<TreeNode , TreeNode> parent){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                parent.put(node.left,node);
                queue.offer(node.left);
            }
             if(node.right!=null){
                parent.put(node.right,node);
                queue.offer(node.right);
            }
        }
    }
}