import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static double[] array;
	static int pSum(int X,int N, double cur, int depth)
	{
		int count = 0;		
		
		for(int i = (int)cur ; i < X ; i++)
		{
			double sum = 0;
			array[depth] = Math.pow(i, N);
			for(int j = 0; j < array.length ; j++)
			{
				sum += array[j];
			}
			
			if(sum == X) 
			{				
				array[depth] = 0;
				System.out.println(depth+":"+i+"true");
				return count+1;
			}
			else if(sum > X)
			{
				array[depth] = 0;
				System.out.println(depth+":"+i+"=>"+sum+"false");
				return count;
			}
			
			System.out.print(depth+":"+i+"=>"+sum+" -> ");
			
			count += pSum(X,N,i+1,depth+1);
		}	
		
		return count;
	}
	
    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
    	
    	int count = 0;
    	array = new double[X];
    	
    	count = pSum(X,N,1,0);
    			
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
