/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/8/7
 * @Description 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode p1 = pre;
        ListNode p2 = head;
        while (p2 != null) {
            if (p2 == null || p2.next == null) {
                break;
            }
            p1.next = p2.next;
            p2.next = p2.next.next;
            p1.next.next = p2;
            p1 = p2;
            p2 = p2.next;
        }
        return pre.next;
    }
}
