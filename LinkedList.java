/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

/**
 *
 * @author 2219549
 */

class Node {
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        next = null;
    }
}

public class LinkedList {
    
    Node head;
    
    public LinkedList(){
        head = null;
    }
    
    public void printList(){
        Node currentNode = head;
        while (currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    
    public void addStart(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void addEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else {
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
    
    public void insert(int key, int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            Node pointer = head;
            while(pointer != null){
                if(pointer.data == key){
                    newNode.next = pointer.next;
                    pointer.next = newNode;
                }
                pointer = pointer.next;
            }
        }
    }
    
    public void delete(int data){
        Node i = head;
        Node j = head.next;
        while(i != null){
            if(i.data == data){
                head = j;
                break;
            }
            if(j.data == data){
                i.next = j.next;
            } 
            i = i.next;
            j = j.next;
        }
    }
    
    public int printMid(){
        Node i = head;
        Node j = head;
        while(i != null && j.next != null){
            i = i.next;
            j = j.next.next;
        }
        return i.data;
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addStart(1);
        list.addStart(2);
        list.addStart(3);
        list.addStart(30);
        list.addStart(300);
        list.printList();
        list.delete(2);
        list.printList();
        list.addEnd(4);
        list.printList();
        list.insert(1, 2);
        list.printList();
        list.delete(300);
        list.printList();
        System.out.println(list.printMid());
    }
    
}
