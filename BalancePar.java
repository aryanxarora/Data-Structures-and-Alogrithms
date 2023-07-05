import java.util.Stack;
public class BalancePar {

    public static boolean areBracketsBalanced(String s)
    {
        int i = -1; //-1 is false
        //the code is between this
        char[] stack = new char[s.length()];
        for (char letter : s.toCharArray()) {
            if (letter == '(' || letter == '{' || letter == '[')
                stack[++i] = letter;
            else {
                if (i >= 0){
                   if((stack[i] == '(' && letter == ')') || (stack[i] == '{' && letter == '}') || (stack[i] == '[' && letter == ']'))
                    {
                        i--;
                    } 
                } else {
                    return false;
                }
            }
        }
        // and this
        return i == -1;
    }
 
    public static void main(String[] args)
    {
        String expr = "({()}[][])";
 
        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
        
        
         String expr2 = "({()}[]";
 
        // Function call
        if (areBracketsBalanced(expr2))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}
