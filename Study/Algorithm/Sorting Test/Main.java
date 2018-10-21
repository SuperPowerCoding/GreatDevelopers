
import java.util.Arrays;
import java.util.Random;

public class Main {

	static boolean debugPrint = false;
	static int length = 10000;
	
	static void printArr(int[] arr, int newLineNum)
	{
		if(debugPrint == false) return;
		
		for(int i = 0; i < arr.length ; i++)
		{
			System.out.print(arr[i] + " ");
			
			if((i + 1)%newLineNum == 0)
			{
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		Sort sort = new Sort();		
		
		int[] originalArr = new int[length];
		
		for(int i = 0 ; i < length ; i++)
		{
			originalArr[i] = i;
		}
		
		int randomTimes = random.nextInt(length);
		for(int i = 0 ; i < randomTimes; i++)
		{
			int idx = random.nextInt(length);
			int idx2 = random.nextInt(length);
			
			int temp = originalArr[idx];
			originalArr[idx] = originalArr[idx2];
			originalArr[idx2] = temp;
		}
		
		
		int[] temp;
		long startTime;
		long endTime;
		double runTime;
		
		printArr(originalArr, 20);
		
		// Java sort
		System.out.println("[Java sort]");
		
		temp = Arrays.copyOf(originalArr, originalArr.length);

		startTime = System.currentTimeMillis();

		Arrays.sort(temp);
		
		endTime = System.currentTimeMillis();
		
		runTime = (endTime - startTime)/1000.0;
		
		printArr(temp, 20);
		
		System.out.println("runtime:"+runTime+"\n");
		
		// Selection sort
		System.out.println("[Selection sort]");
		
		temp = Arrays.copyOf(originalArr, originalArr.length);

		startTime = System.currentTimeMillis();

		sort.selectionSort(temp);
		
		endTime = System.currentTimeMillis();
		
		runTime = (endTime - startTime)/1000.0;
		
		printArr(temp, 20);
		
		System.out.println("runtime:"+runTime+"\n");
		
		
		// Insertion sort
		System.out.println("[Insertion sort]");
		
		temp = Arrays.copyOf(originalArr, originalArr.length);

		startTime = System.currentTimeMillis();

		sort.insertionSort(temp);
		
		endTime = System.currentTimeMillis();
		
		runTime = (endTime - startTime)/1000.0;
		
		printArr(temp, 20);
		
		System.out.println("runtime:"+runTime+"\n");
		
		
		// Bubble sort
		System.out.println("[Bubble sort]");
		
		temp = Arrays.copyOf(originalArr, originalArr.length);

		startTime = System.currentTimeMillis();

		sort.bubbleSort(temp);
		
		endTime = System.currentTimeMillis();
		
		runTime = (endTime - startTime)/1000.0;
		
		printArr(temp, 20);
		
		System.out.println("runtime:"+runTime+"\n");
		
		
		// Shell sort
		System.out.println("[Shell sort]");
		
		temp = Arrays.copyOf(originalArr, originalArr.length);

		startTime = System.currentTimeMillis();

		sort.shellSort(temp);
		
		endTime = System.currentTimeMillis();
		
		runTime = (endTime - startTime)/1000.0;
		
		printArr(temp, 20);
		
		System.out.println("runtime:"+runTime+"\n");
		
	}

}
