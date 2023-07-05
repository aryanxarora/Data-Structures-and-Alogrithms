import java.io.*;
import java.util.*;
 
/**
 *
 * @author 2219549
 */
// User defined pair class
class Pair
{
    int first, second;
    Pair(int a, int b)
    {
        first = a;
        second = b;
    }
}
public class SubArray {

    // Utility function to print all subarrays with sum 0
    static void print(ArrayList<Pair> out)
    {
            for (int i = 0; i < out.size(); i++)
            {
                Pair p = out.get(i);
                System.out.println("Subarray found from Index "
                        + p.first + " to " + p.second);
            }
    }
    

    static ArrayList<Pair> findSubArrays(int[] arr, int n)
    {
        //hints:
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();   
        ArrayList<Pair> out = new ArrayList<>();
 
        // your code is between this 
        int sum = 0;
        for (int i = 0; i < n; i++)
            {
                sum += arr[i];
                if (sum == 0)
                    out.add(new Pair(0, i));
                ArrayList<Integer> list = new ArrayList<>();

                if (map.containsKey(sum))
                {
                    list = map.get(sum);
                    for (int it = 0; it < list.size(); it++)
                    {
                            out.add(new Pair(list.get(it) + 1, i));
                    }
                }
                list.add(i);
                map.put(sum, list);
            }
        // and this
           
        return out;
    }
 
 
    // Driver code
    public static void main(String args[])
    {
            int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
            int n = arr.length;
             
            ArrayList<Pair> out = findSubArrays(arr, n);
             
            // if we did not find any subarray with 0 sum,
            // then subarray does not exists
            if (out.size() == 0)
                System.out.println("No subarray exists");
            else
                print(out);
    }
}
