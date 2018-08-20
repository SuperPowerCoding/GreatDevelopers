import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long super_digit(String n)
    {
        if(n.length() == 1)
            return Integer.parseInt(n);
        long sum = 0;
        System.out.print(n+"->");
        for(int i = 0 ; i < n.length() ; i++)
        {
            long temp = Long.parseLong(n.substring(i,i+1)); 
            sum += temp;
            // System.out.print("("+temp+")");
        }
        System.out.println(sum);
        return super_digit(Long.toString(sum));
    }
    
    // Complete the superDigit function below.
    static long superDigit(String n, int k) {
        if(n.length() == 1)
            return Integer.parseInt(n);
        long sum = 0;
        System.out.print(n+"->");
        for(int i = 0 ; i < n.length() ; i++)
        {
             sum += Long.parseLong(n.substring(i,i+1));
        }
        sum = sum * k;
        System.out.println(sum);
        
        return super_digit(Long.toString(sum));     

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        long result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
