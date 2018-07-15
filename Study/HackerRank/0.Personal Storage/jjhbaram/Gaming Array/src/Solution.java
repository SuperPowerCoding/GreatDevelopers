import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the gamingArray function below.
    static String gamingArray(long[] arr) {
        int count = 0;
        int idx = arr.length - 1;
        
        if(idx == 0) return "BOB";  
        
        long curMax = arr[0];
        
    	for(int i = 1; i < arr.length; i++)
    	{
    		if(arr[i] > curMax)	// find currnet max
    		{
    			curMax = arr[i];
    			count++;
    			// idx--;
    		}
    	}
    	
    	count++;
       
        if(count % 2 == 0 )  return "ANDY";
        
        return "BOB";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int arrCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long[] arr = new long[arrCount];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < arrCount; i++) {
                long arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            String result = gamingArray(arr);
            
            System.out.println(result);
            // bufferedWriter.write(result);
            // bufferedWriter.newLine();
        }

        // bufferedWriter.close();

        scanner.close();
    }
}
