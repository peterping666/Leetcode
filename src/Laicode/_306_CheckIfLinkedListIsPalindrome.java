package Laicode;

public class _306_CheckIfLinkedListIsPalindrome {
    /**
     * class ListNode {
     *   public int value;
     *   public ListNode next;
     *   public ListNode(int value) {
     *     this.value = value;
     *     next = null;
     *   }
     * }
     */
    public class Solution {
        public boolean isPalindrome(ListNode head) {
            // Write your solution here
            if(head == null || head.next == null) {
                return true;
            }
            ListNode mid = findMid(head);
            ListNode midHead = reverse(mid.next);
            while(midHead != null) {
                if(head.value != midHead.value) {
                    return false;
                }
                head = head.next;
                midHead = midHead.next;
            }
            return true;
        }

        private ListNode findMid(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            while(head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }

}
