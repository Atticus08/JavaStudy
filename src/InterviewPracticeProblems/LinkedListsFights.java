/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterviewPracticeProblems;

/**
 *
 * @author BigBoss
 */
final public class LinkedListsFights {
    private class ListNode<T> {
       ListNode(T x) {
         value = x;
       }
       T value;
       ListNode<T> next;
    }
    
    /**
     * Removes nodes that match the key argument.
     * @param l Singly Linked List
     * @param k Key 
     * @return Updated Linked List
     */
    public static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        while(l != null && (int)l.value == k)
            l = l.next;
        
        ListNode curr = l;
        ListNode tail = curr;
        while(curr != null) {               
            if ((int)curr.value == k) {            
                tail.next = curr.next;            
                curr = tail.next;
            } else {
                tail = curr;
                curr = tail.next;
            }        
        } 
        return l;
    } 
}
