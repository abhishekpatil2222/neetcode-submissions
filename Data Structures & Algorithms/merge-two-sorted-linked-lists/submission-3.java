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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode start = node;

        while(list1 != null && list2 != null){
            ListNode nxt = new ListNode();
            if(list1.val <= list2.val){
                nxt.val = list1.val;
                list1 = list1.next;
            }else{
                nxt.val = list2.val;
                list2 = list2.next;
            }
            node.next = nxt;
            node = nxt; 
        }
        
    if(list1 != null){
        node.next = list1;
    }else{
        node.next = list2;
    }
    return start.next;
    }
}