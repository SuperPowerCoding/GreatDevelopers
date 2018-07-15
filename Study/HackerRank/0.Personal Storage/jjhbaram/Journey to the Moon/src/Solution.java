import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Solution {

    static long journeyToMoon(int n, int[][] astronaut) {
    	boolean debugPrint = false;
    	long numPairs = 0;
    	
    	int[] country = new int[n];
    	int[] count = new int[n];
  	
    	// assume all of astronauts are from different country.
    	for(int i = 0 ; i < n; i++)
    	{
    		country[i] = i;
    		count[i] = 1;
    	}
    	    	
    	for(int i = 0 ; i < astronaut.length ; i++)
    	{
    		int c0 = astronaut[i][0];
    		int c1 = astronaut[i][1];
    		
    		if(country[c0] != country[c1])
    		{
				int c = country[c0] < country[c1] ? country[c0] : country[c1];
				int change = country[c0] > country[c1] ? country[c0] : country[c1];
				for(int j = 0; j<n ; j++)
				{
					if(country[j] == change)
					{
						count[change]--;
						country[j] = c;
						count[c]++;
					}
				}        		
    		}
    	}
    	
    	if(debugPrint)
    	{
    		for(int i = 0 ; i< n ; i++)
        	{
        		System.out.println(i+":"+country[i]);
        	}
        	
        	System.out.println("-------------");
        	for(int i = 0 ; i< n ; i++)
        	{
        		int countyrCode = i;
        		System.out.println(countyrCode+":"+count[i]);
        	}
        	System.out.println("-------------");
    	}
    	
    	numPairs = 0;

    	for(int i = 0 ; i< n; i++)
    	{
   			int cnt = n-count[country[i]];   			
    		numPairs += (cnt);
    		
    		if(debugPrint) System.out.println(i+":"+cnt);
    	}
    	
    	numPairs /= 2;
    	return numPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
