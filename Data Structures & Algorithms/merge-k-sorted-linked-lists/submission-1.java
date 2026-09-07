/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode x : lists){
            if(x != null){
                heap.offer(x);
            }
        }
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            res.next = node;
            res = res.next;

            node = node.next;

            if(node != null){
                heap.offer(node);
            }
        }
        return head.next;
    }
}
