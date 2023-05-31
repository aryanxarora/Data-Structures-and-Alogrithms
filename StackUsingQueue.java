/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.util.*;

/**
 *
 * @author 2219549
 */
public class StackUsingQueue {
    
    static class Stack {
        static Queue<Integer> i = new LinkedList<Integer>();
        static Queue<Integer> j = new LinkedList<Integer>();
        static int size;
        
        static void push(int n){
            j.add(n);
            while(!i.isEmpty()){
                j.add(i.peek());
                i.remove();
            }
            Queue<Integer> k = i;
            i = j;
            j = k;
        }
        
        static void pop(){
            if(i.isEmpty()){
                return;
            }
            i.remove();
        }
        
        static void print(){
            System.out.println(Arrays.toString(i.toArray()));
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(0);
        s.pop();
        s.print();
    }
}
