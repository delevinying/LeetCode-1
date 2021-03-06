
/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 *
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/description/
 *
 * algorithms
 * Easy (45.61%)
 * Total Accepted:    2K
 * Total Submissions: 4.3K
 * Testcase Example:  '[2,2,5,null,null,5,7]'
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或
 * 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * 
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   5
 * ⁠    / \
 * ⁠   5   7
 * 
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   2
 * 
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    //TODO:
    public int findSecondMinimumValue(TreeNode root) {
        // return extracted(root);
        if (root == null)
            return -1;
        int min = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left != null) {
            queue.add(root.left);
            queue.add(root.right);
        } else
            return -1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.val < min && node.val != root.val) {
                min = node.val;
            }
            if (node.left != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        else {
            return min;
        }
    }

    private int extracted(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int min = root.val;
        int min2 = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null)
                continue;
            if (node.left.val > min && node.left.val < min2) {
                min2 = node.left.val;
            }
            if (node.right.val > min && node.right.val < min2) {
                min2 = node.right.val;
            }
            if (node.left.val >= min && node.left.val < min2) {
                queue.add(node.left);
            }
            if (node.right.val >= min && node.right.val < min2) {
                queue.add(node.right);
            }
        }
        return min2 == Integer.MIN_VALUE ? -1 : min2;
    }
}
