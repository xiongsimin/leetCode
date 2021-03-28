public class DeleteNode {
    public void deleteNode(ListNode node) {
        //错误思路：只是将当前别名指向了下一节点的地址，上一节点实际还是只想当前节点一开始的地址
        //node=node.next;
        //思路一：将下一节点的值赋给当前节点，当前节点的next指向next的next，以c为例，相当于c复制了d，同时将d删除，以此达到删除c节点同样的效果
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
