/**
 * @Author aries
 * @Data 2021-01-26
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode original = new TreeNode(8);
        /*original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);
        TreeNode cloned = original;
        System.out.println(solution.getTargetCopy(original, cloned, new TreeNode(3)).val);*/
        original.right = new TreeNode(6);
        original.right.right = new TreeNode(5);
        original.right.right.right = new TreeNode(4);
        original.right.right.right.right = new TreeNode(3);
        original.right.right.right.right.right = new TreeNode(2);
        original.right.right.right.right.right.right = new TreeNode(1);
        TreeNode cloned = original;
        System.out.println(solution.getTargetCopy(original, cloned, new TreeNode(4)).val);
    }
}

class Solution {
    /**
     * 深度优先遍历
     *
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Set<TreeNode> visitedSet = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        if (target.val == cloned.val) {
            return cloned;
        }
        visitedSet.add(cloned);
        stack.push(cloned);
        while (stack.size() != 0) {
            TreeNode tempNode = stack.peek();
            if (tempNode.left != null && !visitedSet.contains(tempNode.left)) {
                if (target.val == tempNode.left.val) {
                    return tempNode.left;
                }
                visitedSet.add(tempNode.left);
                stack.push(tempNode.left);
            } else if (tempNode.right != null && !visitedSet.contains(tempNode.right)) {
                if (target.val == tempNode.right.val) {
                    return tempNode.right;
                }
                visitedSet.add(tempNode.right);
                stack.push(tempNode.right);
            } else {
                stack.pop();
            }
        }
        return null;
    }

}