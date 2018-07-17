import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the getWays function below.
	// Complete the getWays function below.
    static long getWays(long n, long[] c) {
        long[] ways = new long[(int)n+1];
        
        ways[0] = 1;
        
        for(int i = 0 ; i < c.length ; i++)
        {
            if(c[i] > n) continue;
                
            ways[(int)c[i]] += 1;
            
            for(int j = 1; j <= n; j++ )
            {
                if(j-c[i] > 0)
                {
                    ways[j] += ways[j-(int)c[i]];
                    // System.out.println(j+":"+ways[j]);
                }                
            }
        }
        int w = (int)n;
        // System.out.println(ways[w]);
        
        return ways[w];
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        System.out.println(ways);

        // bufferedWriter.close();

        // scanner.close();
    }
}
