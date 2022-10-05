/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/10/4
 */
public class Test1 {
    int res = 0;
    int rank = 0;

    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        /*****************/
        traverse(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        Test1 test1 = new Test1();
        test1.traverse(root, 3);
    }
}
