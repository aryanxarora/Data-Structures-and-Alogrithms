class LinkedList
{
    Node head;  // head of list
  
    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
  
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }
        System.out.println();
    }
  
  
    // Main function that inserts nodes of linked list q into p at
    // alternate positions. Since head of first list never changes
    // and head of second list/ may change, we need single pointer
    // for first list and double pointer for second list.
    void merge(LinkedList q)
    {
        //your code is between this
        Node i = head;
        Node j = head;
        while(i != null)
        {
            j = i.next;
            i.next = q.head;
            q.head = j;
            
            i = i.next;
        }
        // and this
    }
  
    
}
public class MergeLinkedList {

    public static void main(String args[])
    {
        LinkedList llist1 = new LinkedList();
        LinkedList llist2 = new LinkedList();
        llist1.push(3);
        llist1.push(2);
        llist1.push(1);
  
        System.out.println("First Linked List:");
        llist1.printList();
  
        llist2.push(8);
        llist2.push(7);
        llist2.push(6);
        llist2.push(5);
        llist2.push(4);
  
        System.out.println("Second Linked List:");
        llist2.printList();
        
        llist1.merge(llist2);
  
        System.out.println("Modified first linked list:");
        llist1.printList();
  
        System.out.println("Modified second linked list:");
        llist2.printList();
    }
}
