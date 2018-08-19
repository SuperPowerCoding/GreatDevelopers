import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

	static int totalSum = 0;   
	
    // Complete the solve function below.
    static int solve(int[] data, int[][] edges) { 
    	// int tree[][] = new int[data.length+1][data.length + 1];
    	ArrayList<Integer> tree[] = new ArrayList[data.length+1];
    	int lastData = 0;
    	// int cnt[] = new int[data.length+1];
    	boolean[] visit = new boolean[data.length+1];
    	int minimun = Integer.MAX_VALUE;
    	
    	int countTrip = 0;
    	for(int i = 0 ; i < tree.length ; i++)
    	{
    		tree[i] = new ArrayList<>();
    	}    	
    	
    	// make tree
    	for(int i = 0 ; i < edges.length ; i++)
    	{
    		int p0 = edges[i][0];
    		int p1 = edges[i][1];
    		
    		// tree[p0][p1] = tree[p1][p0] = 1;
    		tree[p0].add(p1);
    		tree[p1].add(p0);
    		// cnt[p0]++;
    		// cnt[p1]++;
    	}
    	
    	/*
    	for(int i = 0 ; i < tree.length ; i++)
    	{
    		System.out.print(i+"("+tree[i].size()+"):");
    		for(int j = 0 ; j < tree[i].size() ; j++)
    		{
    			System.out.print(tree[i].get(j)+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	*/
    	// System.out.println(tree[2].indexOf(3));
    	
    	
    	int i = 0;
    	while(countTrip < data.length - 1)
    	{
    		if((visit[i] == false) && (tree[i].size() == 1))
    		{
    			System.out.print(i+" ");
    			
    			visit[i] = true;
    			int rest = totalSum - data[i-1];
    			int dif = Math.abs(rest - data[i-1]);
    			if(minimun > dif) minimun = dif;
    			countTrip++;    	
    			
    			int next = tree[i].get(0);
    			
    			// System.out.print("("+next+")");
    			int idx = tree[next].indexOf(i);
    			// System.out.println("["+idx+"]");
    			tree[next].remove(idx);
    			data[next-1] += data[i-1];
    			
    			i = tree[next].size() == 1 ? next : i+1;
    			
    			
    			continue;
    		} 
    		
    		i++;
    		
    		if(i >= data.length)
    		{
    			i = 0;
    		}
    	}
    	
    	return minimun;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] data = new int[n];

        String[] dataItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int dataItem = Integer.parseInt(dataItems[i]);
            data[i] = dataItem;
            totalSum += dataItem;
            // System.out.print(data[i]+" ");
        }
        System.out.println();
        
        int[][] edges = new int[n-1][2];

        for (int i = 0; i < n-1; i++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int edgesItem = Integer.parseInt(edgesRowItems[j]);
                edges[i][j] = edgesItem;
            }
        }

        int result = solve(data, edges);

        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}



