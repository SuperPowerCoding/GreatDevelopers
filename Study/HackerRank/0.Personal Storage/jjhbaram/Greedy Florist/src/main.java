import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class main {

    // Complete the getMinimumCost function below.
    static long getMinimumCost(int k, long[] c) {
    	int cnt = 0;
    	long sum = 0;    	
    	long cur = 1;    	
    	boolean debugPrint = false;
    	
    	Arrays.sort(c);
    	    	
    	if(debugPrint)
    	{
    		for(int i = 0 ; i < c.length ; i++)
    		{
    			System.out.print(c[i]+" ");
    		}
    		System.out.println();
    	}
    	
    	for(int i = c.length - 1; i >=0 ; i--)
    	{
    		sum += (cur) * c[i];
    		System.out.println(cur);
    		if(++cnt == k)
    		{
    			cnt = 0;
    			cur++;    			
    		}
    	}
    	
    	return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        long[] c = new long[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        long minimumCost = getMinimumCost(k, c);
        System.out.println(minimumCost);
        // bufferedWriter.write(String.valueOf(minimumCost));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
