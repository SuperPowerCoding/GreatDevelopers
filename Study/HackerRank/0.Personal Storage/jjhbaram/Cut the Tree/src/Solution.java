import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


//오름차순
class Ascending implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
	   return o1.compareTo(o2);
	}

}


public class Solution {

	static int MAXIMUN_INPUT	=	100000+1;
	
	static int minimun = Integer.MAX_VALUE;
	static boolean[] visit = new boolean[MAXIMUN_INPUT];
	static ArrayList<Integer> tree[] = new ArrayList[MAXIMUN_INPUT];
	
	static int[] data = new int[MAXIMUN_INPUT];
	
	static int totalSum = 0;
	static boolean rec = true;	
	
    static int dfsRc(int start)
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
                sum += dfsRc(next);
            }
        }
        
        System.out.println("("+sum + ")");
        
        int rest = totalSum - sum;
        int dif = sum > rest ? sum - rest : rest - sum;
        
        if(minimun > dif) minimun = dif;
        
        // System.out.print("("+dif + ")");
        
        return sum;
    }
	
    static Stack<Integer> posStack = new Stack<>();
	static Stack<Integer> sumStack = new Stack<>();
	static Stack<Integer> cntStack = new Stack<>();
	
	static void dfs(int start)
	{
		int pos;
		int tempSum = 0;
		int cnt = 0;
		
		// System.out.print(start + " ");
		boolean pop = false;
		
		pos = start;
		int sum = 0;
		
		posStack.push(0);
		sumStack.push(0);
		cntStack.push(0);

        do
		{			
        	pop = true;        	

        	if(tempSum == 0)
        	{
        		visit[pos] = true;
    			sum = data[pos - 1];    			
    			System.out.print(pos + " ");
        	}
        	else	        	// has return val
        	{
        		sum += tempSum;
        	}
        	
			for(int i = cnt ; i < tree[pos].size(); i++)
			{
				int next = tree[pos].get(i);
				// System.out.print("["+next+"]");
				
				if (visit[next] == false) {
					// save current
					// cnt = i;
					posStack.push(pos);
					sumStack.push(sum);
					cntStack.push(i);
					
					
					// do next
					pos = next;
					tempSum = 0;
									
					pop = false; 
					break; 
				}
			}
        	
			
			// have to return
			if(pop)
			{								
				
				System.out.println("("+sum + ")");	
				
				int rest = totalSum - sum;
		        int dif = sum > rest ? sum - rest : rest - sum;
		        
		        if(minimun > dif) minimun = dif;  
        
		        tempSum = sum;
		        
		        // restore
		        pos = posStack.pop();
		        sum = sumStack.pop();
		        cnt = cntStack.pop();
		        
		        //System.out.print("["+dif+","+sum+"]");		        
		       //System.out.println("return:"+pos+","+tempSum+"]");
			}

		}while(posStack.isEmpty() == false);
        
        
        sum += tempSum;
        
        System.out.println("("+sum + ")");	
        
        int rest = totalSum - sum;
        int dif = sum > rest ? sum - rest : rest - sum;
        
        if(minimun > dif) minimun = dif;  
        
        
	}
	
	
    // Complete the solve function below.
    static int solve() { 
    	
    	/*
    	for(int i = 0 ; i < tree.length ; i++)
    	{
    		Ascending ascending = new Ascending();
            Collections.sort(tree[i], ascending);
    	}
    	*/

		
		
		if(rec == true)
		{
			dfsRc(1);
		}
		else
		{
			dfs(1);
		}
    		
    	System.out.println();
    	
    	return minimun;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        data = new int[n];

        // String[] dataItems = scanner.nextLine().split(" ");
        
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            //int dataItem = Integer.parseInt(dataItems[i]);
        	int dataItem = scanner.nextInt();
            data[i] = dataItem;
            totalSum += dataItem;
            System.out.print(data[i]+" ");
            tree[i] = new ArrayList<Integer>();    	
        }
        
        tree[n] = new ArrayList<Integer>();    	
        
        System.out.println();
        
        int[][] edges = new int[n-1][2];

        for (int i = 0; i < n-1; i++) {
            // String[] edgesRowItems = scanner.nextLine().split(" ");
            // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                // int edgesItem = Integer.parseInt(edgesRowItems[j]);
                edges[i][j] = scanner.nextInt();
            }
            int p0 = edges[i][0];
            int p1 = edges[i][1];
            
            tree[p0].add(p1);
    		tree[p1].add(p0);
        }

        int result = solve();

        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}



