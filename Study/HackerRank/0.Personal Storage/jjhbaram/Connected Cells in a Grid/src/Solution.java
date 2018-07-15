import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static void checkConnected(int[][] matrix,int oY, int oX, int val)
	{
		int[][] dir = 
    	{
    		// y, x
    		{-1, -1},	// ↖
    		{-1, +0},	// ↑
    		{-1, +1},	// ↗
    		{+0, -1},	// ←
    		{+0, +1},	// →
    		{+1, -1},	// ↙
    		{+1, +0},	// ↓
    		{+1, +1},	// ↘
    	};
		
		for(int k = 0; k < dir.length ; k++)
		{
			// 인접한 곳에 뭔가 있음    					
			int y = oY+dir[k][0];
			int x = oX+dir[k][1];
			
			if(y >= matrix.length || x >= matrix[0].length) continue;
			if(y < 0 || x < 0) continue;
			
			if(matrix[y][x] != 0)
			{
				if(matrix[y][x] == 1)
				{
					System.out.println("find connected cell:"+y+","+x);
					matrix[y][x] = val;
					checkConnected(matrix, y, x, val);					
				}
			}
		}
	}
	
    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
    	int result = 0;
    	int setVal = 2;
    	
    	for(int i = 0 ; i < matrix.length ; i++)
    	{
    		for(int j = 0 ; j < matrix[i].length ; j++)
    		{
    			if(matrix[i][j] == 1)
    			{
    				System.out.println("find  a filled cell:"+i+","+j);
    				
    				matrix[i][j] = setVal++;   				
    				
    				checkConnected(matrix,i,j,matrix[i][j]);
    			}
    		}
    	}
    	
    	int[] count = new int[setVal - 2];
    	for(int i = 0 ; i < matrix.length ; i++)
    	{
    		for(int j = 0 ; j < matrix[0].length ; j++)
    		{
    			int val = matrix[i][j];
    			System.out.print(val+" ");
    			if(val != 0)
    			{
    				count[val - 2]++;
    			}
    			
    		}
    		System.out.println();
    	}
    	
    	
    	for(int i = 0 ; i < count.length ; i++)
    	{
    		if(count[i] > result) result = count[i];
    	}
    	
    	
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);
        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        //scanner.close();
    }
}
