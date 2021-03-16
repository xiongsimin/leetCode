/**
 * @author xiongsm
 * @Date 2021-03-16
 * @Description 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * @示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * @示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * @示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * @提示： k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {
    ListNode head = null;

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        if (lists.length == 0) {
            return head;
        }
        head = lists[0];
        result = mergeKCore(lists, lists.length);
        return result;
    }

    /**
     * 合并K个链表
     *
     * @param lists
     * @param n
     * @return
     */
    private ListNode mergeKCore(ListNode[] lists, int n) {
        if (n == 1) {
            return head;
        }
        mergeTwoList(head, lists[lists.length - n + 1]);
        return mergeKCore(lists, n - 1);
    }

    /**
     * 合并两个链表
     *
     * @param l1
     * @param l2
     */
    public void mergeTwoList(ListNode l1, ListNode l2) {
        //先确定链表头
        if (l1 == null) {
            head = l2;
            return;
        } else if (l2 == null) {
            head = l1;
            return;
        }
        head = l1.val < l2.val ? l1 : l2;
        ListNode current = head;
        ListNode nextA = head.next;
        ListNode nextB = head == l1 ? l2 : l1;
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
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();


        //[[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[3];
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(4);
        ListNode one3 = new ListNode(5);

        one1.next = one2;
        one2.next = one3;
        lists[0] = one1;

        ListNode two1 = new ListNode(1);
        ListNode two2 = new ListNode(3);
        ListNode two3 = new ListNode(4);

        two1.next = two2;
        two2.next = two3;
        lists[1] = two1;

        ListNode three1 = new ListNode(2);
        ListNode three2 = new ListNode(6);

        three1.next = three2;
        lists[2] = three1;

        ListNode result = mergeKLists.mergeKLists(lists);
        ListNode cur = result;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
