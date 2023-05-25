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
public class StackArray {
    
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX];
    
    public StackArray(){
        this.top = -1;
    }
    
    public boolean isFull(){
        return top >= MAX-1;
    }
        
    public boolean isEmpty(){
        return top < 0;
    }
    
    public void print(){
        System.out.println("Stack:");
        for(int i = top; i >= 0; i--){
            System.out.println(a[i]);
        }
    }
    
    public void push(int data){
        if(isFull()){
            System.out.println("Stack Overflow!");
        } else {
            a[++top] = data;
        }
    }
    
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow!");
            return -1 * MAX;
        } else {
            return a[top--];
        }
    }
    
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Undefined!");
            return 0;
        } else {
            return a[top];
        }
    }
    
}
