/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import java.util.ArrayList;

/**
 *
 * @author 2219549
 */
public class Subject {
    
    ArrayList<Observer> observers = new ArrayList<Observer>();
    int state;
    
    public Subject(int state){
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    
    public void attach(Observer observer){
        observers.add(observer);
    }
    
    public void notifyAllObservers(){
        System.out.println("State: " + state);
        for(Observer observer: observers){
            observer.update();
        }
        System.out.println("");
    }
    
}
