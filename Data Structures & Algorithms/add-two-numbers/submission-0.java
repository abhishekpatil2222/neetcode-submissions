class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ensure l1 is longer
        ListNode h1 = l1, h2 = l2;
        while (h1 != null && h2 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        if (h2 != null) { // l2 is longer → swap
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode curr1 = l1, curr2 = l2;
        int carry = 0;

        // add both lists
        while (curr1 != null) {
            int sum = curr1.val + carry + (curr2 != null ? curr2.val : 0);

            curr1.val = sum % 10;
            carry = sum / 10;

            // move pointers
            if (curr2 != null) curr2 = curr2.next;

            // if at end and still carry → create node
            if (curr1.next == null && carry > 0) {
                curr1.next = new ListNode(carry);
                carry = 0;
                break;
            }

            curr1 = curr1.next;
        }

        return l1;
    }
}