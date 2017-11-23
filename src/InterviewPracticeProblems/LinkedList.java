/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterviewPracticeProblems;

/**
 * Singly Linked List Class
 * @author Tom Fritz
 * @param <T>
 */
public class LinkedList<T> {
    // Linked List Node
    private class ListNode {              
       T value;
       ListNode next;       
       
       ListNode(T x) {
         value = x; 
         next = null;
       }
    }        
    // The head of the Linked List
    private ListNode head;
    private ListNode ptr;
    
    /**
     * Print the linked list
     * @author Tom Fritz
     */
    public void printList() {
        ListNode tmpNode = head;
        while (tmpNode != null) {
            System.out.println(tmpNode + "->");
            tmpNode = tmpNode.next;
        }
        System.out.println("FIN");
    }
    
    /**
     * Insert Node at the beginning of the linked list
     * @param data 
     * @author Tom Fritz
     */
    public void insertAtBeginning(T data) {
        // If the list is already empty, set the head to be equal to the new node.
        if (!isAddingFirstNode(data)) {
            // Create new node, push the node on the list and set it's next
            // to be the head node, and then reset the head to the new node.
            ListNode tmp = new ListNode(data);
            tmp.next = this.head;
            this.head = tmp;            
        }
    }
    
    /**
     * Insert a node at the end of the linked list.
     * @param data 
     * @author Tom Fritz
     */
    public void insertAtEnd(T data) {
        if (!isAddingFirstNode(data)) {
            ListNode newNode = new ListNode(data);
            // Set the linked list pointer to the head node, and loop through
            // the list until we find the end.
            this.ptr = this.head;            
            while (this.ptr.next != null) {
                this.ptr = this.ptr.next;
            }
            
            // The pointer is at the end of the list, and we set the pointer's
            // next to point at the new node in the list.
            newNode.value = data;
            newNode.next = null;
            this.ptr.next = newNode;            
        }
    }
    
    /**
     * Check to see if the first node is being added to the list, then
     * let the caller know that the new was added.
     * @param data Data to be added to link node
     * @return Response on whether the new node was inserted at the beginning
     * of the list.
     * @author Tom Fritz
     */
    private boolean isAddingFirstNode(T data) {
        boolean added = false;
        if (this.head == null) {
            this.head.value = data;
            this.head.next = null;
            added = true;
        }
        return added;
    }
    
    /**
     * Removes nodes that match the key argument.
     * @param l Singly Linked List
     * @param k Key 
     * @return Updated Linked List
     * @author Tom Fritz
     */
    public ListNode removeKFromList(ListNode l, T k) {
        while(l != null && (T)l.value == k)
            l = l.next;
        
        ListNode curr = l;
        ListNode tail = curr;
        while(curr != null) {               
            if ((T)curr.value == k) {            
                tail.next = curr.next;            
                curr = tail.next;
            } else {
                tail = curr;
                curr = tail.next;
            }        
        } 
        return l;
    } 
    
    /**
     * @param args the command line arguments
     */
//    private static void main(String[] args) {   
//        LinkedList<Integer> list = new LinkedList();
//        int[] nums = {1,3,5,4};
//        long startTime = System.currentTimeMillis();
//        
//        list.insertAtBeginning(nums[0]);
//        list.printList();
//        
//        long endTime = System.currentTimeMillis();
//        long duration = (endTime - startTime);         
//        System.out.print("\n And this is the Time it took to calculate in s: " + duration + "\n");
//    }    
}
