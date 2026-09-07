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
        ListNode head = new ListNode(-1, null);
        ListNode curr = head;

        while(true){
            int minIndex = -1;
            
            for(int i=0; i < lists.length; i++){
                if(lists[i] != null){
                    if(minIndex == -1 || lists[minIndex].val > lists[i].val){
                        minIndex = i;
                    }
                }
            }
        if(minIndex == -1) return head.next;
        curr.next = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        curr = curr.next;
        }
    }
}
