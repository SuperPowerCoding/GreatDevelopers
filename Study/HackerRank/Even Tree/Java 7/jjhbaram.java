import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
static ArrayList<Integer> tree[]; //  = new ArrayList[t_nodes];
    static boolean checked[];
    static int result;
    
    static int dfs(int start)
    {
        int count = 1;
        checked[start] = true;
        System.out.print(start + "->");
        
        for(int i = 0 ; i < tree[start].size() ; i++)
        {
            int next = tree[start].get(i);
            if(checked[next] == false)
            {
                count += dfs(next);
            }
        }
        
        // System.out.print(start);
        
        // if there is no another way to go, count
        System.out.print("("+count + ")");
        if(count % 2 == 0 )    // check even
        {
            System.out.println();            
            result++;
        }
        
        return count;
    }
    
    // Complete the evenForest function below.
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        tree = new ArrayList[t_nodes + 1];
        for(int i = 0 ; i < tree.length; i++)
        {
            tree[i] = new ArrayList<Integer>();
        }
        
        
        for(int i = 0 ; i < t_edges; i++)
        {
            int a = t_from.get(i);
            int b = t_to.get(i);
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        checked = new boolean[t_nodes + 1];
        result = 0;
        
        
        dfs(1);
        result--;
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        for (int i = 0; i < tEdges; i++) {
            String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            tFrom.add(Integer.parseInt(tFromTo[0]));
            tTo.add(Integer.parseInt(tFromTo[1]));
        }

        int res = evenForest(tNodes, tEdges, tFrom, tTo);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
