package sandbox;

class Node {
    int data;
    Node next;
    Node prev;
    
    public Node(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}

public class DoublyLinkedList {

    Node head;
    
    public DoublyLinkedList(){
        head = null;
    }
    
    public void printList(){
        Node pointer = head;
        while(pointer != null){
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }
    
    public void printEach(){
        Node pointer = head;
        while(pointer != null){
            System.out.println("Prev: " + (pointer.prev == null ? "null" : pointer.prev.data) + 
                    " Node: " + pointer.data + 
                    " Next: " + (pointer.next == null ? "null" : pointer.next.data));
            pointer = pointer.next;
        }
    }
    
    public void insertTail(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            Node pointer = head;
            while(pointer != null){
                if(pointer.next == null){
                    newNode.prev = pointer;
                    pointer.next = newNode;
                    break;
                }
                pointer = pointer.next;
            }
        }
    }
    
    public void insertHead(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            Node pointer = head;
            newNode.next = pointer;
            pointer.prev = newNode;
            head = newNode;
        }
    }
    
    public void delete(int data){
        Node pointer = head;
        while(pointer != null)
        {
            if(pointer.data == data)
            {
                Node temp = pointer;
                if(pointer.next != null){
                    pointer.next.prev = pointer.prev;
                }
                pointer.prev.next = temp.next;
            }
            pointer = pointer.next;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);
        list.insertTail(4);
        list.delete(4);
        list.printList();
        list.printEach();
    }
    
}
