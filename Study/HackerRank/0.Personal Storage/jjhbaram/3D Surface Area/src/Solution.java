import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int surfaceArea(int[][] A) {
        // Complete this function
        int sum = 0;
        boolean debugPrint = true;
        
        int dir[][]  = 
        {
        //   x,y
            {-1,+0},    // ก่
            {+0,+1},    // กๆ
            {+1,+0},    // ก้
            {+0,-1}     // ก็
        };
        
        
        boolean[][] check = new boolean[A.length][];
        
        for(int i = 0 ; i < A.length; i++)
        {
            check[i] = new boolean[A[i].length];
        }
        
        for(int i = 0 ; i < A.length ; i++)
        {
            for(int j = 0 ; j < A[i].length ; j++)
            {
                // surface area                 
                int surface = A[i][j] >= 2 ? (A[i][j] - 2) * 4 + 5 * 2 : 6;
                            
                for(int k = 0 ; k < dir.length ; k++)
                {
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    
                    if( x < 0 || x >= A.length)      continue;
                    if( y < 0 || y >= A[i].length)   continue;
                    
                    if(check[x][y] == true ) 
                    {
                        surface -= (A[x][y] < A[i][j] ? A[x][y] : A[i][j])*2;
                    }
                }
                
                check[i][j] = true;
                sum += surface;
                if(debugPrint) System.out.print(surface+" ");
            }
            
            if(debugPrint) System.out.println();
            
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for(int A_i = 0; A_i < H; A_i++){
            for(int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A);
        System.out.println(result);
        in.close();
    }
}
