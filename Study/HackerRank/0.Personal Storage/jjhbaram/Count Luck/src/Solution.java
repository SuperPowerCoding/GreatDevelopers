import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static int wand = 0;
	
	static void printMat(char[][] mat)
	{
    	for(int i = 0 ; i < mat.length ; i++)
		{
			for(int j = 0 ; j < mat[i].length ; j++)
			{
				char obj = mat[i][j];
				System.out.print(obj);
			}
			System.out.println();
		}    	
	}
	
	static boolean DFS(char[][] mat, int oy, int ox)
	{
		int[][] dir = {{-1,+0},{+0,+1},{+1,+0},{+0,-1}};
		int count = 0;
		boolean check = false;
		
		
		for(int i = 0 ; i < dir.length ; i++)
		{
			int y = oy + dir[i][0];
			int x = ox + dir[i][1];
			
			// check range
			if( y < 0 || x < 0 || y >= mat.length || x >= mat[y].length) continue;
			
			char obj = mat[y][x];
			if(obj == '.')	// can move spot
			{
				count++;
				mat[y][x] = '0';
				if(DFS(mat,y,x) == true) check = true;
			}
			else if(obj == '*')	// destination.
			{
				count++;
				check =  true;
			}
		}
		
		if(count >= 2 && check)
		{
			wand++;
			mat[oy][ox] = '1';
			return true;
		}
		
		// can't anywhere
		if(count == 0) check =  false;
		
		if(check == false)
		{
			mat[oy][ox] = '.';
		}
		
		return check;
	}
	
	// Complete the countLuck function below.
    static String countLuck(String[] matrix, int k) {

    	int y = 0;
    	int x = 0;
    	
    	char[][] mat = new char[matrix.length][];
    	
    	for(int i = 0 ; i < matrix.length; i++)
    	{
    		mat[i] = new char[matrix[i].length()];
    	}
    	
    	for(int i = 0 ; i < matrix.length ; i++)
		{
			for(int j = 0 ; j < matrix[i].length() ; j++)
			{
				char obj = matrix[i].charAt(j);
				if(obj == 'M')
				{
					y = i;
					x = j;
				}
				mat[i][j] = obj;
			}
		}
		
    	
    	
    	
    	wand = 0;
    	DFS(mat,y,x);
    	printMat(mat);
    	
    	System.out.println(wand);
    	
    	if(wand == k)	return "Impressed";    	
    	
    	return "Oops!";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            System.out.println(result);
            // bufferedWriter.write(result);
            // bufferedWriter.newLine();
        }

        // bufferedWriter.close();

        scanner.close();
    }
}
