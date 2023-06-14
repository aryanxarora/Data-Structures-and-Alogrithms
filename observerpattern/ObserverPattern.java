package observerpattern;

public class ObserverPattern {

    public static void main(String[] args) {
        Subject subject = new Subject(10);
        BinaryObserver bin = new BinaryObserver(subject);
        OctalObserver oct = new OctalObserver(subject);
        HexaObserver hex = new HexaObserver(subject);
        
        subject.setState(15);
        subject.setState(20);
        subject.setState(8942);
    }
    
}
