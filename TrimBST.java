/**

递归比较直观。也可以遍历。

*/

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
    // 递归
    public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (root == null) return null;
        
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
    }
    
    // 遍历
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        //Find a valid root which is used to return.
        while (root.val < L || root.val > R) {
            if (root.val < L) {
                root = root.right;
            }
            if (root.val > R) {
                root = root.left;
            }
        }
        TreeNode dummy = root;
        // Remove the invalid nodes from left subtree.
        while (dummy != null) {
            while (dummy.left != null && dummy.left.val < L) {
                dummy.left = dummy.left.right; 
                // If the left child is smaller than L, then we just keep the right subtree of it. 
            }
            dummy = dummy.left;
        }
        dummy = root;
        // Remove the invalid nodes from right subtree
        while (dummy != null) {
            while (dummy.right != null && dummy.right.val > R) {
                dummy.right = dummy.right.left;
                // If the right child is biggrt than R, then we just keep the left subtree of it. 
            }
            dummy = dummy.right;
        }
        return root;
    }
}
