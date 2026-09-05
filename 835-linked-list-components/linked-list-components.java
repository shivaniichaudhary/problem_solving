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
    public int numComponents(ListNode head, int[] nums) {
       
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int components = 0;
        ListNode curr = head;

        while (curr != null) {
           
            if (numSet.contains(curr.val) && 
               (curr.next == null || !numSet.contains(curr.next.val))) {
                components++;
            }
            curr = curr.next;
        }

        return components;
    }
}