/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.util.ArrayList;

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
    
    public boolean checkDuplicate(){
        Node pointer = head;
        while(pointer != null && pointer.next != null){
            if(pointer.data == pointer.next.data){
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }
    
    public void reverseList(){
        Node current = head;
        Node previous = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    
    public boolean detectLoop(){
        ArrayList<Node> list = new ArrayList<Node>();
        boolean loop = false;
        
        Node pointer = head;
        while(pointer != null){
            if(list.contains(pointer)){
                loop = true;
                break;
            }
            list.add(pointer);
            pointer = pointer.next;
        }
        
        return loop;
    }
    
    public void removeLoop(){
        ArrayList<Node> list = new ArrayList<Node>();
        Node pointer = head;
        while(pointer != null){
            if(list.contains(pointer.next)){
                pointer.next = null;
            }
            list.add(pointer);
            pointer = pointer.next;
        }
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addStart(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addEnd(5);
        list.addEnd(3);
        list.addEnd(6);
        list.addEnd(7);
        list.head.next.next.next.next.next.next.next.next = list.head.next.next;
        System.out.println(list.detectLoop());
        if(list.detectLoop()){
            list.removeLoop();
        }
        list.printList();
    }
    
}
