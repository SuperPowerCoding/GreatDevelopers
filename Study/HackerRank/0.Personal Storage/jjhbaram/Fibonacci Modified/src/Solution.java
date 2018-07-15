import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {
    	BigInteger[] table = new BigInteger[n];

    	table[0] = new BigInteger(String.valueOf(t1));
    	table[1] = new BigInteger(String.valueOf(t2));
    	
    	for(int i = 2 ; i < n ; i++)
    	{
    		table[i] = new BigInteger("0");
    		BigInteger t_2 = new BigInteger(String.valueOf(table[i-2]));
    		BigInteger t_1 = new BigInteger(String.valueOf(table[i-1]));
    		t_1 = t_1.multiply(t_1);
    		table[i] = table[i].add(t_1);
    		table[i] = table[i].add(t_2);
    		System.out.println(i+":"+table[i]);
    	}
    	
    	return table[n-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        System.out.println(String.valueOf(result));
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
