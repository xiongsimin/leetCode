/**
 * @Author aries
 * @Data 2021-01-26
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    /**
     * 深度优先遍历 todo  忘了
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