import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int[] sorted;
    static int[] inputArr;
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    
	
    /*
	1. �����ؾ� �ϴ� ��Ҹ� �˱� ���� Hash map�� �����.
	
	2. ������������ ������ �迭��, �������� ������ ������ �Ѵ�.
	
	3. ���ĵ� �迭�� �̿��Ͽ�, ������������ ������ �Ѵ�.
	
	*/
    static int ascendingCnt(int[] input, HashMap<Integer, Integer> map)
    {
        int cnt = 0;
        
        for(int i = 0 ; i < input.length; i++)
        {
            // ���ĵ� �Ͱ� input�� �ٸ���.... ����!
            if(input[i] != sorted[i])
            {
                cnt++;
                int target = (int)map.get(sorted[i]);
                int temp = input[target];                
                input[target] = input[i];
                input[i] = temp;
                
                // �Ѱ��� �̹� fix �Ǿ����� ������ �ٲ� ���� idx ���� �ٲٸ� ��.
                map.put(input[target], target);                
            }
        }
        
        return cnt;
    }
    
    static int descendingCnt(int[] input, HashMap<Integer, Integer> map)
    {
        int cnt = 0;
        int n = input.length - 1;
        
        for(int i = 0 ; i < input.length; i++)
        {
            if(input[i] != sorted[n-i])
            {
                cnt++;
                
                int target = (int)map.get(sorted[n-i]);
                int temp = input[target];                
                input[target] = input[i];
                input[i] = temp;
                
                // �Ѱ��� �̹� fix �Ǿ����� ������ �ٲ� ���� idx ���� �ٲٸ� ��.
                map.put(input[target], target);             
            }
        }
        
        return cnt;
    }
    
    // Complete the lilysHomework function below.
    static int lilysHomework() {
                
        Arrays.sort(sorted);
                
        int ascending = ascendingCnt(Arrays.copyOf(inputArr, inputArr.length), new HashMap<Integer, Integer>(map));
        int descending = descendingCnt(Arrays.copyOf(inputArr, inputArr.length), new HashMap<Integer, Integer>(map));        
        
        System.out.println(ascending+","+descending);
        
        return ascending > descending ? descending : ascending;
        //return ascending;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        sorted = new int[n];
        inputArr = new int[n];
        
        for(int i = 0 ; i < n; i++)
        {
            int val = scanner.nextInt(); 
            inputArr[i] = val;
            sorted[i] = val;
            map.put(val, i);
        }

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = lilysHomework();
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
