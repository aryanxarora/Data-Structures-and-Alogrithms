package sandbox;

class Node {
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        next = null;
    }
}

public class RemoveNthNodeFromEnd {

    Node head;
    
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            Node pointer = head;
            while(pointer != null){
                if(pointer.next == null){
                    pointer.next = newNode;
                    break;
                }
                pointer = pointer.next;
            }
        }
    }
    
    public void print(){
        Node pointer = head;
        while(pointer != null){
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
    }
    
    public void find(int n){
        Node x = head;
        Node y = head;

        for(int i = 0; i < n - 1; i++){
            y = y.next;
        }
        while(y!=null){
            if(y.next == null){
                System.out.println("\nvalue="+x.data);
                break;
            }
            x=x.next;
            y=y.next;  
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        RemoveNthNodeFromEnd list = new RemoveNthNodeFromEnd();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        list.add(100);
        list.print();
        list.find(5);
    }
    
}
