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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null){
                que.offer(node.left);
            }
            if(node.right != null){
                que.offer(node.right);
            }
        }

        return root;
    }
}
