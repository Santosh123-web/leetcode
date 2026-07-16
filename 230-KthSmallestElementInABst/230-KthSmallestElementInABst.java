// Last updated: 7/16/2026, 4:07:37 PM
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
    int count=0;
    int ans=-1;
   
    public int kthSmallest(TreeNode root, int k) {
        if(root.left!=null){
            kthSmallest(root.left,k);
        }
        count++;
        if(k==count){
            ans=root.val;
            return ans;
        }
        if(root.right!=null){
            kthSmallest(root.right,k);
        }
        return ans;
        
        
    }
}