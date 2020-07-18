package Laicode;

import java.util.HashMap;
import java.util.HashSet;

public class _288_FirstNonRepeatingCharacterInStream {
    public class Solution {
        class ListNode{
            Character val;
            ListNode prev;
            ListNode next;

            ListNode(Character c) {
                val = c;
            }
        }
        private ListNode head;
        private ListNode tail;
        private HashMap<Character, ListNode> singled;
        private HashSet<Character> repeated;

        public Solution() {
            singled = new HashMap<>();
            repeated = new HashSet<>();
            head = tail = new ListNode(null);
        }

        public void read(char ch) {
            if(repeated.contains(ch)) {
                return;
            }
            if(singled.containsKey(ch)) {
                remove(ch);
            } else {
                append(ch);
            }
        }

        private void append(Character ch) {
            ListNode newNode = new ListNode(ch);
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
            singled.put(ch, newNode);
        }

        private void remove(Character ch) {
            ListNode target = singled.get(ch);
            if(target == tail) {
                tail = tail.prev;
                tail.next = null;
                target.prev = null;
            } else {
                target.next.prev = target.prev;
                target.prev.next = target.next;
                target.next = null;
                target.prev = null;
            }
            singled.remove(ch);
            repeated.add(ch);
        }

        public Character firstNonRepeating() {
            return head.next == null ? null : head.next.val;
        }
    }

}
