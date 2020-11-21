/**
 * @Author aries
 * @Data 2020-11-21
 * @Description 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 *  
 * @示例： 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/*Definition for singly-linked list.*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class DeleteNode {
    public void deleteNode(ListNode node) {
        //错误思路：只是将当前别名指向了下一节点的地址，上一节点实际还是只想当前节点一开始的地址
        //node=node.next;
        //思路一：将下一节点的值赋给当前节点，当前节点的next指向next的next，以c为例，相当于c复制了d，同时将d删除，以此达到删除c节点同样的效果
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
