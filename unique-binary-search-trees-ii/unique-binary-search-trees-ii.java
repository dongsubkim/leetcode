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
    
    
    public List<TreeNode> generateTrees(int n) {
        return gen(1, n);
    }
    
    List<TreeNode> gen(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = gen(start, i-1);
            List<TreeNode> right = gen(i+1, end);
            for (TreeNode l:left) {
                for (TreeNode r:right) {
                    res.add(new TreeNode(i, l, r));
                }
            }
        }
        return res;
    }
}