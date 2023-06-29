/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddtobst;

import java.util.ArrayList;

class Node {
    int data;
    Node right;
    Node left;
    
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class DoublyLinkedList {
    Node head;
    int size;
    
    public DoublyLinkedList(){
        head = null;
        size = 0;
    }

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            Node pointer = head;
            while(pointer != null){
                if(pointer.right == null){
                    newNode.left = pointer;
                    pointer.right = newNode;
                    break;
                }
                pointer = pointer.right;
            }
        }
        size++;
    }

    public void print(){
        Node pointer = head;
        while(pointer != null){
            System.out.print(pointer.data + " ");
            pointer = pointer.right;
        }
    }

}

class BinarySearchTree {
    Node root;
    
    public BinarySearchTree(){
        root = null;
    }
    
    public void add(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        } else {
            Node pointer = root;
            while(true){
                if(newNode.data > pointer.data){
                    if(pointer.right == null){
                        pointer.right = newNode;
                        break;
                    } else {
                        pointer = pointer.right;
                    }
                } else if(newNode.data < pointer.data){
                    if(pointer.left == null){
                        pointer.left = newNode;
                        break;
                    } else {
                        pointer = pointer.left;
                    }
                }
            }
        }
    }
    
    public void preOrderTraversal(Node node){
        if(node == null){
            return;
        } else {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}

public class DLtoBST  {
    
    static BinarySearchTree bst = new BinarySearchTree();
    
    public static Node balancedBSTRecur(ArrayList<Integer> list, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        if((end - start) % 2 != 0){
            mid = mid + 1;
        }
        Node root = new Node(list.get(mid));
        root.left = balancedBSTRecur(list, start, end-1);
        root.right = balancedBSTRecur(list, mid + 1, end);
        return root;
    }
    
    public static Node balancedBST(Node head){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Node pointer = head;
        while(pointer != null){
            list.add(pointer.data);
            pointer = pointer.right;
        }
        return balancedBSTRecur(list, 0, list.size() - 1);
    }
    
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.add(10);
        dl.add(20);
        dl.add(30);
        dl.add(40);
        dl.add(50);
        dl.add(60);
        dl.add(70);
        dl.add(80);
        dl.add(90);
        dl.add(100);
        dl.print();
        
        Node root = balancedBST(dl.head);
        
        bst.preOrderTraversal(root);
    }
    
}
