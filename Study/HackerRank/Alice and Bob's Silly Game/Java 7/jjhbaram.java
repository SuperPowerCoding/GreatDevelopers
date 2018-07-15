import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the sillyGame function below.
     */
    static String sillyGame(int n) {
        /*
         * Write your code here.
         */
		boolean[] primeNum = new boolean[n+1];
		int count = 0;
		
		primeNum[0] = true;
		primeNum[1] = true;
		
		for(int i = 2; i <= n ; i++)
		{
			if(primeNum[i] == false)
			{
				count++;
				for(int j = 2 ; j*i < primeNum.length; j++)
				{
					primeNum[i*j] = true;
				}
			}
		}
		
		if(count % 2 == 0)	return "Bob";
		
		return "Alice";
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            String result = sillyGame(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
