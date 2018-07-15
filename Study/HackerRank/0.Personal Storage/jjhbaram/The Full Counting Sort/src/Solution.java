import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
    	boolean debugPrint = true;
    	
    	int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        StringBuffer[] str = new StringBuffer[n];
        int max = 0;

        
        for(int i = 0 ; i < str.length ; i++)
        {
        	str[i] = new StringBuffer();
        }
        
        for (int nItr = 0; nItr < n; nItr++) {
            String[] xs = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xs[0]);

            String s = xs[1];
            
            if(x > max)  max = x;
            
            if(nItr < n/2)
            {
            	s = "-";
            }
            
            // str[x] += s+" ";
            str[x].append(s+" ");
        }
        
        for(int i = 0 ; i <= max ; i++)
        {        	
        	System.out.print(str[i]);

        }
        scanner.close();
    }
}
