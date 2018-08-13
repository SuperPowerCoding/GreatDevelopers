import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int MAXIMUN_INPUT    =    100000+1;
    
    static int minimun = Integer.MAX_VALUE;
    
    static boolean[] visit = new boolean[MAXIMUN_INPUT];
    static ArrayList<Integer> tree[] = new ArrayList[MAXIMUN_INPUT];
    
    static int[] data = new int[MAXIMUN_INPUT];
    
    static int totalSum = 0;

   static int dfs(int start)
    {
        System.out.print(start + " ");
        
        int sum = 0;
        visit[start] = true;
        sum += data[start - 1];
        
        for(int i = 0 ; i < tree[start].size() ; i++)
        {
            int next = tree[start].get(i);
            if(visit[next] == false)
            {
                sum += dfs(next);
            }
        }
        
        System.out.println("("+sum + ")");
        
        int rest = totalSum - sum;
        int dif = sum > rest ? sum - rest : rest - sum;
        
        if(minimun > dif) minimun = dif;
        
        // System.out.print("("+dif + ")");
        
        return sum;
    }
    
    
    // Complete the solve function below.
    static int solve() { 
        dfs(1);        
        return minimun;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // data = new int[n];

        for (int i = 0; i < n; i++) {
            int dataItem = scanner.nextInt();
            data[i] = dataItem;
            totalSum += dataItem;
            // System.out.print(data[i]+" ");
            tree[i] = new ArrayList<Integer>();        
        }
        
        tree[n] = new ArrayList<Integer>();        
        
        // System.out.println();
        
        int[][] edges = new int[n-1][2];

        for (int i = 0; i < n-1; i++) {           

            for (int j = 0; j < 2; j++) {
                int edgesItem =scanner.nextInt();
                edges[i][j] = edgesItem;
                
            }            
            int p0 = edges[i][0];
            int p1 = edges[i][1];
            tree[p0].add(p1);
            tree[p1].add(p0);
        }

        int result = solve();

        // System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}



