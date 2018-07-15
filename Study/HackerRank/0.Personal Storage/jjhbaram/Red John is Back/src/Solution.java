import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static int INPUT_MAX = 40;
	// static int PRIMENUM_MAX = 217286;
	static int PRIMENUM_MAX = 500000;
	
	static int[][] combiTable = null;	
	
	
	static void InitCombination()
	{
		if(combiTable != null)	return;
		
		combiTable = new int[INPUT_MAX][];
    	for(int i = 0 ; i < INPUT_MAX ; i++)
    	{
    		combiTable[i] = new int[i+1];
    		combiTable[i][0] = 1;
    		combiTable[i][i] = 1;
    	}
	}
	
	static int combination(int n, int k)
	{
		if(n == 0 || k == n || k == 0)	return 1;
		
		if(k > n)	return 1;
		
		if(combiTable[n][k] == 0) return combination(n-1,k-1) + combination(n-1,k);
			
		return combiTable[n][k];
		
	}
	
	static int[] ways = new int[41];
	
	static int getWays(int n)
	{
		int sum = 0;
		if(ways[n] == 0 )
		{
			for(int k = 0 ; n >= 0 ; n-=4,k++)
	    	{
	    		int num = n+k;
	    		int com = combination(num,k);
	    		
	    		sum += com;
	    		// System.out.println(num+"C"+k+"="+com);
	    	}
		}
		else
		{
			return ways[n];
		}
		
		return sum;
	}
	
	static int[] primeNum = null; 
	
	static void makePrimeNum()
	{
		// PRIMENUM_MAX
		if(primeNum != null) return;
			
		boolean[] temp = new boolean[PRIMENUM_MAX];
		int cnt = 0;
	
		cnt += 2;
		
		for(int i = 2 ; i < PRIMENUM_MAX ; i++)
		{
			if(temp[i] == false)
			{
				// temp[i] = false;
				cnt++;
				
				for(int j = 2 ; i*j < PRIMENUM_MAX ; j++)
				{					
					temp[i*j] = true;
				}
			}
		}
		
		primeNum = new int[cnt];
		
		int idx = 0;
		
		for(int i = 2 ; i < PRIMENUM_MAX ; i++)
		{
			if(temp[i] == false)
			{
				primeNum[idx++] = i;
			}
		}
	}
	
	
    // Complete the redJohn function below.
    static int redJohn(int n) {
 
    	int sum = 0;
    	
    	
    	InitCombination();
    	
    	sum = getWays(n);
    	
    	System.out.println(sum);
    	
    	makePrimeNum();
    	
    	int primeCnt = 0;
    	
    	for(primeCnt = 0 ; primeCnt < primeNum.length ; primeCnt++)
    	{
    		if(primeNum[primeCnt] > sum)	break;
    	}
    	
    	return primeCnt;    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = redJohn(n);
            System.out.println(String.valueOf(result));
            // bufferedWriter.write(String.valueOf(result));
            // bufferedWriter.newLine();
        }

        // bufferedWriter.close();

        scanner.close();
    }
}
