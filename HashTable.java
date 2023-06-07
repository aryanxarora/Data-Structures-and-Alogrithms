/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.util.ArrayList;

class Node {
    int key;
    String data;
    Node next;
    
    public Node(int key, String data){
        this.key = key;
        this.data = data;
        next = null;
    }
}

public class HashTable {
    
    ArrayList<Node> hashtable = new ArrayList<Node>();
    int buckets;
    int size = 0;
    
    public HashTable(int buckets){
        this.buckets = buckets;
        for(int i = 0; i < buckets; i++){
            hashtable.add(null);
        }
    }
    
    public int getBucketIndex(int key){
        int index = key % buckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }
    
    public void add(int key, String data){
        int index = getBucketIndex(key);
        Node head = hashtable.get(index);
        Node node = new Node(key, data);
        
        if(head != null){
            hashtable.set(index, node);
            node.next = head;
        } else {
            hashtable.set(index, node);
        }
        size++;
    }
    
    public String get(int key){
        int index = getBucketIndex(key);
        Node pointer = hashtable.get(index);
        if(pointer == null){
            return null;
        } else {
            while(pointer != null){
                if(pointer.key == key){
                    return pointer.data;
                }
                pointer = pointer.next;
            }
        }
        return null;
    }
    
    public boolean remove(int key){
        int index = getBucketIndex(key);
        Node pointer = hashtable.get(index);
        if(pointer == null){
            return false;
        } else {
            while(pointer != null){
                if(pointer.key == key){
                    pointer = null;
                }
                pointer = pointer.next;
            }
        }
        return false;
    }
    
    public void print(){
        for(int i = 0; i < buckets; i++){
            Node pointer = hashtable.get(i);
            if(pointer != null){
                System.out.print("Bucket " + i + ": ");
                while(pointer != null){
                    System.out.print("(" + pointer.key + ", " + pointer.data + ") ");
                    pointer = pointer.next;
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        HashTable hash = new HashTable(6);
        hash.add(1, "a");
        hash.add(2, "b");
        hash.add(3, "c");
        hash.add(7, "d");
        //hash.add(1, "e");
        //System.out.println(hash.get(10));
        hash.print();
    }
    
}
