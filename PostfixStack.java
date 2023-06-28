package sandbox;

import java.util.*;

public class PostfixStack {
    
    public static void PrintStack(Stack<Integer> s)
    {
        if (s.empty())
            return;
        int x = s.peek();
        s.pop();
        System.out.print(x + " ");
        PrintStack(s);
        s.push(x);
    }
        
    public static void solution(String str){
        Stack<Integer> s = new Stack<Integer>();
        String[] p = str.split(" ");
        for(int i = 0; i < p.length; i++){
            try {
                int x = Integer.parseInt(p[i]);
                s.push(x);
            } 
            catch(NumberFormatException e) {
                switch(p[i]){
                    case "+":
                        if(s.size() > 1){
                            s.push(s.pop() + s.pop());
                        } else {
                            s.push(-1);
                            break;
                        }
                        break;
                    case "-":
                        if(s.size() > 1){
                            s.push(s.pop() - s.pop());
                        } else {
                            s.push(-1);
                            break;
                        }
                        break;
                    case "DUP":
                        s.push(s.peek());
                        break;
                    case "POP":
                        s.pop();
                        break;
                }
            }
//            PrintStack(s);
//            System.out.println("");
        }
        System.out.println(s.pop());
    }
    
    public static void main(String[] args) {
        
        String[] p = new String[8];
        p[0] = "4 5 6 - 7 +";
        p[1] = "13 DUP 4 POP 5 DUP + DUP + -";
        p[2] = "5 6 + -";
        p[3] = "3 DUP 5 - -";
        p[4] = "4 5 6 - 7 +";
        p[5] = "13 DUP 4 POP 5 DUP + DUP + -";
        p[6] = "5 6 + -";
        p[7] = "3 DUP 5 - -";
        
        for(int i = 0; i < 8; i++){
            solution(p[i]);
        }
        
    }
    
}