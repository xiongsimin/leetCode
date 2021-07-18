/**
 * @Author aries
 * @Data 2021-07-18
 * @Description 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head1 = new ListNode(-1);
        ListNode p1 = head1;
        p1.next = null;
        ListNode head2 = new ListNode(-1);
        ListNode p2 = head2;
        p2.next = null;
        ListNode index = head;
        while (index != null) {
            if (index.val < x) {
                p1.next = index;
                p1 = p1.next;
                index = index.next;
                p1.next = null;
            } else {
                p2.next = index;
                p2 = p2.next;
                index = index.next;
                p2.next = null;
            }

        }
        //连接两个链表区间
        if (head1.next != null) {
            p1.next = head2.next;
            return head1.next;
        } else {
            return head2.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Partition partition = new Partition();
        ListNode result=partition.partition(head, 0);

        while (result != null) {
            System.out.println(result.val + "->");
            result=result.next;
        }
    }
}
