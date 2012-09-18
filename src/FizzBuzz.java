/**
 * 
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @since Apr 5, 2012 9:20:54 PM
 *
 * @version RCMS 
 *
 * @author <a href="mailto:abharadia@ismnet.com">abharadia</a>
 * 
 */
interface IChecker { boolean check(int n); }  

class ConstantChecker implements IChecker {  
    private int k;  
    private String msg;  
    ConstantChecker(int k, String msg) { this.k = k; this.msg = msg; }  
    public boolean check(int n) {  
        boolean nDivisibleByK = (n % k == 0);  
        if (nDivisibleByK) System.out.print(msg);  
        return nDivisibleByK;  
    }  
}      
      
public class FizzBuzz {  
    public static void main(String[] argv) {  
        List<IChecker> checkers = new ArrayList<IChecker>();  
        checkers.add(new ConstantChecker(3, "fizz"));  
        checkers.add(new ConstantChecker(5, "buzz"));  
  
        for (int n=1; n<=100; ++n) {  
            boolean printedSomething = false;  
            for (IChecker checker: checkers)   
                printedSomething |= checker.check(n);              
            if (!printedSomething)  
                System.out.print(n);  
            System.out.println();  
        }  
    }  
}