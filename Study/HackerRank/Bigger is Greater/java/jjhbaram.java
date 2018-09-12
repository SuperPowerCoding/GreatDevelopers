import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
 
    static boolean getNextNum(int[] n)
    {
        boolean debugPrint = false;
        
        if(n.length == 1)   return false;
        
     
        // find position that will be changed
        int i = n.length - 1;
        if(debugPrint) System.out.print(i+"->");
        while((i-1>=0) && (n[i-1] >= n[i]))
        {
            i--;
        }        
        i--;
        if(debugPrint) System.out.println(i);
        
        if(i < 0)  return false;
        
        // find bigger number of n[i]
        int j = n.length - 1;
        while(n[i] >= n[j])
        {
            j--;
        }
        
        if(debugPrint) System.out.println(j);
        
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
        
        j = n.length - 1;
        i++;
        while (i < j) {
            temp = n[i];
            n[i] = n[j];
            n[j] = temp;
            i++;
            j--;
        }
        
        return true;
    }
    
    
    static String biggerIsGreater(String w) {
        // Complete this function
        int[] wi = new int[w.length()];
        
        for(int i = 0 ; i < w.length() ; i++)
        {
            wi[i] = w.charAt(i) - 'a';
        }
        
        // next number
        if(getNextNum(wi) == false) return "no answer";
        else
        {
            char[] str = new char[wi.length];
            
            for(int i = 0 ; i < wi.length ; i++)
            {
               str[i] = (char)((char)wi[i] + 'a');
            }
            
            return new String(str,0,str.length);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            String w = in.next();
            String result = biggerIsGreater(w);
            System.out.println(result);
        }
        in.close();
    }
}
