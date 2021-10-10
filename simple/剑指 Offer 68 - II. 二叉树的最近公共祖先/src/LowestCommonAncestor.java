import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author aries
 * @Data 2021-08-10
 * @Description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();
        buildHash(root, hashMap);
        HashSet<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = hashMap.get(p);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = hashMap.get(q);
        }
        return root;
    }

    void buildHash(TreeNode node, HashMap<TreeNode, TreeNode> hashMap) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            hashMap.put(node.left, node);
            buildHash(node.left, hashMap);
        }
        if (node.right != null) {
            hashMap.put(node.right, node);
            buildHash(node.right, hashMap);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        root.left = p;
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        TreeNode q = new TreeNode(4);
        root.left.right.right = q;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, p, q).val);
    }
}
