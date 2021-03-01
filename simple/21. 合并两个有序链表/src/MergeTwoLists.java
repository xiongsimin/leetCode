/**
 * @Author aries
 * @Data 2021-02-25
 * @Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * @示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * @示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 * @提示： 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {
    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
        //确定结果的头结点
        ListNode21 head = l1.val >= l2.val ? l2 : l1;
        ListNode21 currentNode;
        return head;
    }


}

class ListNode21 {
    int val;
    ListNode next;

    ListNode21() {
    }

    ListNode21(int val) {
        this.val = val;
    }

    ListNode21(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


