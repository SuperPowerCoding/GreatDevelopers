import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static int maxMapSize = 200;
	static int[][] map = new int[maxMapSize][maxMapSize];
	static int[][] pos = new int[maxMapSize*maxMapSize][2];
	static int[] length = new int[maxMapSize*maxMapSize];	
	static int cnt = 0;
	
	// 큐에 좌표 정보와 길이를 삽입하는 함수
	static void enqueue(int _x, int _y, int _l)
	{
	    pos[cnt][0] = _x;
	    pos[cnt][1] = _y;	    
	    length[cnt] = _l;
	    cnt++;
	}	
	
	static void BFS(int n, int i_start, int j_start, int i_end, int j_end)
	{
		boolean debugPrint = false;
		
		int[][] dir = 
		{
			//	 x	y
				{-1,-2},	// UL
				{+1,-2},	// UR
				{+2,+0},	// R
				{+1,+2},	// LR
				{-1,+2},	// LL
				{-2,+0},	// L
		};
		
		int[][] dirReverse = 
		{
//			 x	y
			{+2,+0},	// L
			{+1,-2},	// LL	
			{-1,-2},	// LR
			{-2,+0},	// R
			{-1,+2},	// UR
			{+1,+2},	// UL
		};
		
		// reversed dir Str
		String[] dirStr = 
		{
			//	 x	y
			"L",	// L
			"LL",	// LL
			"LR", 	// LR
			"R",	// R
			"UR",	// UR
			"UL", 	// UL				
		};
		
		int idx = 0;
		enqueue(j_start,i_start,0);
		map[i_start][j_start] = 1;
		
		while(idx < cnt && (pos[idx][0] != j_end || pos[idx][1] != i_end))
		{
			for(int i = 0 ; i< dir.length ; i++)
			{
				int x = pos[idx][0] + dir[i][0];
				int y = pos[idx][1] + dir[i][1];
				
				if(x < 0 || x >= n || y < 0 || y >= n) continue;
				
				if(map[y][x] == 0)
				{
					enqueue(x,y,length[idx]+1);
				}
				
				map[y][x] = 1;
			}			
			idx++;
		}
		
		ArrayList<String> outputStr = new ArrayList<>();
		
		if(idx < cnt)
		{
			enqueue(pos[idx][1],pos[idx][0],length[idx]+1);
			
			if(debugPrint)
			{
				System.out.println("result("+length[idx]+")"+pos[idx][1]+","+pos[idx][0]);
				for(int i = 0 ; i <= idx ; i++)
				{
					System.out.println(pos[i][1]+","+pos[i][0]+":"+length[i]);
				}
			}
			
			int preX = pos[idx][0];
			int preY = pos[idx][1];
			int minPos = dir.length;
			
			int i = idx - 1;
			int checkLength = length[idx] - 1;
			int sidx = idx;
			
			
			
			System.out.println(length[idx]);
			
			while(i >= 0)
			{
				int x = pos[i][0];
				int y = pos[i][1];
				
				if(length[i] != checkLength)
				{
					i--;
					continue;
				}
				
				for(int j = 0 ; j< dirReverse.length ; j++)
				{
					if( ((x - preX) == dirReverse[j][0]) && ((y - preY) == dirReverse[j][1]))
					{
						if(minPos > j) 
						{
							minPos = j;
							sidx = i;
						}
							
					}
				}
				
				i--;
				
				int curLen = i >= 0 ? length[i] : -1;
				
				if(checkLength != curLen)
				{
					if(minPos != dir.length)
					{
						if(debugPrint)
						{
							System.out.print(dirStr[minPos]+" ");
							System.out.println(":"+preY+","+preX+"=>"+pos[sidx][1]+","+pos[sidx][0]+"->"+length[sidx]);	
						}										
						
						outputStr.add(dirStr[minPos]);
						
						checkLength--;
						preX = pos[sidx][0];
						preY = pos[sidx][1];
						minPos = dir.length;
					}
					
				}				
			}
		}
		else
		{
			System.out.println("Impossible");
			return;
		}
		
		for(int i = outputStr.size() - 1; i >= 0  ; i--)
		{
			System.out.print(outputStr.get(i)+" ");
		}
		
	}
	
	
	
    // Complete the printShortestPath function below.
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        // Print the distance along with the sequence of moves.
    	BFS(n,i_start,j_start,i_end,j_end);
    	// BFS(n,i_end,j_end, i_start,j_start);
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] i_startJ_start = scanner.nextLine().split(" ");

        int i_start = Integer.parseInt(i_startJ_start[0]);

        int j_start = Integer.parseInt(i_startJ_start[1]);

        int i_end = Integer.parseInt(i_startJ_start[2]);

        int j_end = Integer.parseInt(i_startJ_start[3]);

        printShortestPath(n, i_start, j_start, i_end, j_end);

        scanner.close();
    }
}
