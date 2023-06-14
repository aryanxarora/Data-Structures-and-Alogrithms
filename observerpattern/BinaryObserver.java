/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

/**
 *
 * @author 2219549
 */
public class BinaryObserver extends Observer {

    Subject subject;
    
    public BinaryObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
    
    @Override
    public void update() {
        // calculate binary of state;
        int state = subject.getState();
        System.out.println("Binary: " + Integer.toBinaryString(state));
    }
    
}
