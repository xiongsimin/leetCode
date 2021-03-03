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
        //先确定链表头
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode21 head = l1.val < l2.val ? l1 : l2;
        ListNode21 current = head;
        ListNode21 nextA = head.next;
        ListNode21 nextB = head == l1 ? l2 : l1;
        //依次按升序将节点串起来
        while (nextA != null && nextB != null) {
            if (nextA.val < nextB.val) {
                current.next = nextA;
                current = nextA;
                nextA = nextA.next;
            } else {
                current.next = nextB;
                current = nextB;
                nextB = nextB.next;
            }
        }
        //当一个链表到末尾时，仅需将其尾部与另一个链表下个元素连接起来就可以
        if (nextA == null) {
            current.next = nextB;
        } else {
            current.next = nextA;
        }
        return head;
    }

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode21 one3 = new ListNode21(4);
        ListNode21 one2 = new ListNode21(2, one3);
        ListNode21 one1 = new ListNode21(1, one2);

        ListNode21 two3 = new ListNode21(4);
        ListNode21 two2 = new ListNode21(3, two3);
        ListNode21 two1 = new ListNode21(1, two2);
        ListNode21 result = mergeTwoLists.mergeTwoLists(one1, two1);
        ListNode21 head = result;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}


class ListNode21 {
    int val;
    ListNode21 next;

    ListNode21() {
    }

    ListNode21(int val) {
        this.val = val;
    }

    ListNode21(int val, ListNode21 next) {
        this.val = val;
        this.next = next;
    }
}

