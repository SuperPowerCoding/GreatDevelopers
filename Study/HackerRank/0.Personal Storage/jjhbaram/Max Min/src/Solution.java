import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the angryChildren function below.
    static int angryChildren(int k, int[] arr) {
    	boolean debugPrint = true;
    	int minVal = Integer.MAX_VALUE;    	
    	
    	Arrays.sort(arr);
    	
    	for(int i = 0 ; i < arr.length - k +1; i++)
    	{
    		int max = arr[i+k-1];
    		int min = arr[i];
    		int unfairness = max - min;
    		if(unfairness < minVal) minVal = unfairness;
    		
    		if(debugPrint) System.out.println(i + ":"+unfairness+"="+max+"-"+min);
    	}
    	
    	return minVal;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = angryChildren(k, arr);

        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
