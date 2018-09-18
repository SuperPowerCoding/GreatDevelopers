import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
Becareful this case
[input]
6 7 9
.......
...O...
....O..
O......
OO.....
.OO....

[simulation]
2sec
0000000
0002000
0000200
2000000
2200000
0220000

3sec
111.111
11...11
.11...1
..11.11
...1111
....111

4sec
2220222
2200022
0220002
0022022
0002222
0000222

5sec
.......
...1...
....1..
1......
11.....
111....

[result]
.......
...O...
....O..
O......
OO.....
OOO....
*/
public class Solution {

    static final char bomb = 79;
    static final char blank = '.';
    static final char willBeBlank = '1';
    
    static boolean debugPrint = false;
            
    static int[][] afterOneSec(int[][] grid)
    {
        int[][] dir =
        {
            // i , j 
                {+1,+0},    // 상
                {-1,+0}, // 하
                {+0,-1}, // 좌
                {+0,+1}, // 우
        };
        
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[i].length ; j++)
            {
                if(grid[i][j] != -2)
                {
                    grid[i][j]++;
                }
                
                if(grid[i][j] == 3)
                {
                    grid[i][j] = -2;
                    for(int k = 0; k < dir.length ; k++)
                    {
                        int x = j + dir[k][1];
                        int y = i + dir[k][0];
                        
                        if( x < 0 || x >= grid[i].length) continue;
                        if( y < 0 || y >= grid.length) continue;
                        
                        if(grid[y][x] != 3 && grid[y][x] != 2)
                        grid[y][x] = -2;
                    }
                }
            }
        }
        
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[i].length ; j++)
            {
                if(grid[i][j] == -2)
                {
                    grid[i][j] = -1;
                }
                if(debugPrint)
                {
                    if(grid[i][j] == -1)
                    {
                        System.out.print(blank);
                    }
                    else
                    {
                        System.out.print(grid[i][j]);
                    }
                }
                
                
            }
            
            if(debugPrint)System.out.println();
        }
        
        
        return grid;
    }
    
    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        
        if(n == 1) return grid;
        
        char[][] ch = new char[grid.length][];
        
        for(int i = 0 ; i < grid.length ; i++)
        {
            ch[i] = new char[grid[i].length()];
        }
        
        int[][] map = new int[grid.length][];        
        for(int i = 0 ; i < grid.length ; i++)
        {
            map[i] = new int [grid[i].length()];
        }
        
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0; j < grid[i].length() ; j++)
            {
                if(grid[i].charAt(j) == bomb)
                {
                    map[i][j] = 1;
                }
                else
                {
                    map[i][j] = -1;
                }
            }
        }
        
        if( n % 2 == 0)
        {
            n = 2;
        }
        else if(n == 3)
        {
            // do nothing
        }
        else if((n+3) % 4 == 0) // when 4k - 1 = n  where k = 2,3,4... => n = 5,9,11 
        {
            n = 5;
        }
        else
        {
            n = 7;
        }
        
        // 2. after n sec (after 2sec)
        for(int i = 0 ; i < n-1; i++)
        {
            if(debugPrint)System.out.println((i+2) + "sec");
            map = afterOneSec(map);
            if(debugPrint)System.out.println();
        }
        
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0; j < grid[i].length() ; j++)
            {
                if(map[i][j] == -1)
                {
                    ch[i][j] = blank;
                }
                else
                {
                    ch[i][j] = bomb;
                }
                
            }
        }  
        
        String[] returnGrid = new String[grid.length];
        
        for(int i = 0 ; i < returnGrid.length ; i++)
        {
            returnGrid[i] = new String(ch[i]);
        }
        
        return returnGrid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
