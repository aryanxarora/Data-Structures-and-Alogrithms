/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 2219549
 */

public class Sandbox {

    /**
     * @param args the command line arguments
     */
    
    static class Pair {
        int first, second;
        Pair(int a, int b) {
            first = a;
            second = b;
        }
    }
    
    static ArrayList<Pair> findSubArrays(int[] arr, int n){
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Pair> out = new ArrayList<Pair>();
        
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += arr[j];
                if(sum == 0){
                    System.out.println("Subarray: " + i + " " + j);
                    temp.add(j);
                }
            }
            map.put(i, temp);
        }
        return out;
    }
    
    static void print(ArrayList<Pair> out){
        for(int i = 0; i < out.size(); i++){
            Pair p = out.get(i);
            System.out.println("Subarray found : " + p.first + " to " + p.second);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        ArrayList<Pair> result = findSubArrays(arr, arr.length);
        print(result);
    }
    
}
