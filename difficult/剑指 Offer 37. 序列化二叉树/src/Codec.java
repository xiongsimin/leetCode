/**
 * @author xiongsm
 * @Date 2021-07-27
 * @Description 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        //前序
        StringBuilder frontOrderStr = new StringBuilder();
        frontVisit(root, frontOrderStr);
        //中序
        StringBuilder inOrderStr = new StringBuilder();
        inVisit(root, inOrderStr);
        return frontOrderStr.substring(0, frontOrderStr.length() - 1) + ";" + inOrderStr.substring(0, inOrderStr.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] serials = data.split(";");
        //前序序列
        return null;
    }

    static void frontVisit(TreeNode node, StringBuilder str) {
        if (node == null) {
            return;
        }
        str.append("[").append(node.toString()).append(":").append(node.val).append("]").append(",");
        frontVisit(node.left, str);
        frontVisit(node.right, str);
    }

    static void inVisit(TreeNode node, StringBuilder str) {
        if (node == null) {
            return;
        }
        inVisit(node.left, str);
        str.append("[").append(node.toString()).append(":").append(node.val).append("]").append(",");
        inVisit(node.right, str);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(Codec.serialize(root));
    }
}
