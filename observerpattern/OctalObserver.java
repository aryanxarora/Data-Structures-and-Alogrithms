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
public class OctalObserver extends Observer {

    Subject subject;
    
    public OctalObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
    
    @Override
    public void update() {
        int state = subject.getState();
        System.out.println("Octal: " + Integer.toOctalString(state));
    }
    
}
