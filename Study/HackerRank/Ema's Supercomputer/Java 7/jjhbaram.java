import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class Point
    {
        public int x;
        public int y;
        public int size;
    }
    
    static int[][] dir =
    {
            // i , j
            {+1,+0},    // up
            {-1,+0},    // down
            {+0,-1},    // left
            {+0,+1},    // right
    };
    
    static ArrayList<Point> findAllPoint(char[][] map)
    {
        ArrayList<Point> pt = new ArrayList<>();
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                // find good cell
                if(map[i][j] == 'G')
                {
                    // check good plus
                    /*
                    if( 
                        (map[i-1][j] == 'G') && (map[i+1][j] == 'G') && 
                        (map[i][j-1] == 'G') && (map[i][j+1] == 'G')
                    )
                    {
                    */
                        Point p = new Point();
                        p.x = j;
                        p.y = i;
                        p.size = getPlusSize(map, p.y, p.x);
                        
                        // System.out.println("found"+j+","+i);
                        
                        pt.add(p);
                    //}
                }
            }
        }
        
        return pt;
    }
    
    static int getPlusSize(char[][] map,int _y, int _x)
    {        
        
        int minSize = Integer.MAX_VALUE;
        for(int i = 0 ; i < dir.length ; i++)
        {
            int size = 0;
            int x = _x + dir[i][1];
            int y = _y + dir[i][0];
            
            while( (y >= 0 && y < map.length) && (x >= 0 && x < map[y].length) && map[y][x] == 'G')
            {
                size++;
                x += dir[i][1]; 
                y += dir[i][0];
            }            
            
            if(minSize > size) minSize = size;
        }
        
        minSize = minSize * 4 + 1;
        
        return minSize;
    }
    
    static char[][] setCell(char[][] map, int _y, int _x, int size, char goodOrBad)
    {
        map[_y][_x] = goodOrBad;
        // System.out.println("setCell"+_y+","+_x+"/"+size);
        for(int i = 0 ; i < dir.length ; i++)
        {
            int y = _y;
            int x = _x;
            for(int l = 0 ; l < size ; l++)
            {
                y += dir[i][0];
                x += dir[i][1];
                        
                map[y][x] = goodOrBad;
            }
        }
        
        for(int i = 0 ; i < map.length ; i++)
        {
            for(int j = 0; j < map[i].length ; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
        
        return map;
    }
    
    
    
    
    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        
        int max = 0;
        
        // convert String to char for convenient
        char [][] map = new char[grid.length][];
        for(int i = 0 ; i < grid.length ; i++)
        {
            map[i] = grid[i].toCharArray();
        }        

        ArrayList<Point> pt = findAllPoint(map);
        
        for(int i = 0 ; i < pt.size(); i++)
        {
            int[] totalSize = new int[2];
            // totalSize[0] = getPlusSize(map, pt.get(j).y, pt.get(j).x);
            totalSize[0] = pt.get(i).size;
            System.out.println("1."+pt.get(i).y +"," +pt.get(i).x +":" + totalSize[0]);
                        
            for(int size = 1 ; size <= pt.get(i).size ; size += 4)
            {
                // set 'B'
                int oneSideSize = (size - 1)/4;
                map = setCell(map, pt.get(i).y, pt.get(i).x, oneSideSize, 'B');

                ArrayList<Point> pt2 = findAllPoint(map);

                for(int j = 0 ; j < pt2.size() ; j++)
                {
                    totalSize[1] = getPlusSize(map, pt2.get(j).y, pt.get(j).x);

                    int temp = size * totalSize[1];

                    if(max < temp) max = temp;

                    System.out.println("2."+pt2.get(j).y +"," +pt2.get(j).x +":" + totalSize[1]);
                    System.out.println(max);
                }

                // revert
                System.out.println("revert");
                map = setCell(map, pt.get(i).y, pt.get(i).x, oneSideSize, 'G');
            }
            
        }
        
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
