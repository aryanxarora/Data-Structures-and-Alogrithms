package sandbox;

import java.util.ArrayList;

class Car {
    private String m_made; 
    private int m_year; 
    
    
    public Car(String make, int year){
        this.m_made = make;
        this.m_year = year;
    }

    public String getM_made() {
        return m_made;
    }

    public int getM_year() {
        return m_year;
    }

    @Override
    public String toString() {
        return "car make: " + m_made + " and year is: " + m_year;
    }

}

class Node {
   int key;
   Car data;
   Node next;
   
   public Node(int key, Car data){
       this.key = key;
       this.data = data;
       next = null;
   }
}

class HashTable{
    private ArrayList<Node> bucketArray; 
    private int numBuckets = 10; 

    public HashTable() 
    { 
        bucketArray =  new ArrayList<>(); 
        for (int i = 0; i < numBuckets; i++) 
            bucketArray.add(null);
    } 
  

    private int getBucketIndex(int key) 
    { 
        int index = key % numBuckets; 
        return index;  
    }
    
    public void add(int key, Car car){
        int index = getBucketIndex(key);
        Node head = bucketArray.get(index);
        Node node = new Node(key, car);
        
        if(head != null){
            bucketArray.set(index, node);
            node.next = head;
        } else {
            bucketArray.set(index, node);
        }
    }
    
    public void printHashTable(){
        for(int i = 0; i < numBuckets; i++){
            Node pointer = bucketArray.get(i);
            if(pointer != null){
                while(pointer != null){
                    System.out.println(pointer.data.toString());
                    pointer = pointer.next;
                }
            }
        }
    }
    
    public void remove(int key){
        int index = getBucketIndex(key);
        Node pointer = bucketArray.get(index);
        if(pointer.key == key){
            bucketArray.set(index, null);
        } else {
            while(pointer != null){
                if(pointer.key == key){
                    pointer = null;
                    break;
                }
                pointer = pointer.next;
            }
        }
    }
    
    public Car get(int key){
        int index = getBucketIndex(key);
        Node pointer = bucketArray.get(index);
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
   
}
public class HT_Cars {

    public static void main(String[] args) {
        HashTable hashCars = new HashTable(); 
        Car car1 = new Car ("Camry", 2023);
        //add and print
        hashCars.add(0,  car1);
        hashCars.add(2,  new Car("BMW", 2000));
        hashCars.add(3,  new Car("Subaru", 2010));
        hashCars.add(10,  new Car("Kia", 2018));
        hashCars.printHashTable();
        
        //remove and print
        hashCars.remove(3);
        System.out.println("\nNew list:");
        hashCars.printHashTable();
        
        //search 
        System.out.println("\nSearch for car with key 10");
        Car carSearch  = hashCars.get(10); 
        if (carSearch !=null)
            System.out.println("car found:\nmake: "+carSearch.getM_made()+" and year is: "+carSearch.getM_year());
        else
            System.out.println("Couldn't find the car");
        
        System.out.println("\nSearch for car with key 20");
        Car carSearch2  = hashCars.get(20); 
        if (carSearch2 !=null)
            System.out.println("car found:\nmake: "+carSearch2.getM_made()+" and year is: "+carSearch2.getM_year());
        else
            System.out.println("Couldn't find the car");
    }
    
}