import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {

        int i,j;
        int count = 0;
        ArrayList<Integer> output = new ArrayList<>();
        
        Arrays.sort(arr); 
        Arrays.sort(brr);    

        i = 0;
        j = 0;
        
        while(i < arr.length)
        {
            if(arr[i] != brr[j])
            {
            	int temp = brr[j++];
            	if(output.contains(temp) == false)
            	{
                    output.add(temp); 
                    System.out.println(temp);
            	}
            }
            else
            {                
                i++;
                j++;
            }
        }
              
        
        if(j <= (brr.length - 1))
        {	
        	int temp = brr[j]; 
        	if(output.contains(temp) == false)
        	{
            	output.add(temp); 
    	        System.out.println(temp);
        	}
        }
        
        int[] result = new int[output.size()];
        
        for(int idx = 0 ; idx < output.size(); idx++)
        {
            result[idx] = output.get(idx);
        }
        
        Arrays.sort(result);
        
        return result;
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);
        
        for (int i = 0; i < result.length; i++) {
        	System.out.print(result[i]+" ");
        }
/*
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }
*/
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        // scanner.close();
    }
}
