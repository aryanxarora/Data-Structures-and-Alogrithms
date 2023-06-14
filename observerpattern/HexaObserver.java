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
public class HexaObserver extends Observer {
    
    public Subject subject;
    
    public HexaObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        int state = subject.getState();
        System.out.println("Hexa: " + Integer.toHexString(state));
    }
    
    
    
}
