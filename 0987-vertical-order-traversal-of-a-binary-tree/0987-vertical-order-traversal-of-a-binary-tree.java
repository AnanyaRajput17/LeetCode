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
 import java.util.*;

class Tupple{
    TreeNode node;
    int level;
    int vertical;
    Tupple(TreeNode node , int level , int vertical){
        this.node = node ;
        this.level = level;
        this.vertical = vertical;

    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Queue<Tupple> queue = new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.offer(new Tupple(root,0,0));
        while(!queue.isEmpty()){
            Tupple t = queue.poll();
            TreeNode node = t.node;
            int val = node.val;
            int level = t.level;
            int vertical = t.vertical;
            if(!map.containsKey(vertical)){
                map.put(vertical,new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level , new PriorityQueue<>());
            }
            map.get(vertical).get(level).offer(val);
            if(node.left!=null){
                queue.offer(new Tupple(node.left,level+1,vertical-1));
            }
             if(node.right!=null){
                queue.offer(new Tupple(node.right,level+1,vertical+1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
            List<Integer> list2 = new ArrayList<>();
            for(PriorityQueue<Integer> ys2 : ys.values()){
                while(!ys2.isEmpty()){
                    list2.add(ys2.poll());
                }
            }
            list.add(new ArrayList<>(list2));
        }
        return list;

    }
}