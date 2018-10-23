
import java.util.Arrays;
import java.util.Random;

public class Main {

	static boolean debugPrint = false;
	
	static int length = 100000;
	
	
	static int[] originalArr;
	//static int[] originalArr = {4,3,2,1,0};
	
	static Sort sort = new Sort();
	
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
	
	
	static void sortTest(int len, int n)
	{
		Random random = new Random();
		int[] sorted = new int[len];
		for(int i = 0 ; i < len ; i++)
		{
			sorted[i] = i;
		}
		
		int[] randomArr = new int[len];		
		
		for(int test = 0; test < n ; test++)
		{
			for(int i = 0 ; i < len ; i++)
			{
				randomArr[i] = i;
			}
			
			int randomTimes = random.nextInt(length);
			for(int i = 0 ; i < randomTimes; i++)
			{
				int idx = random.nextInt(length);
				int idx2 = random.nextInt(length);
				
				int temp = randomArr[idx];
				randomArr[idx] = randomArr[idx2];
				randomArr[idx2] = temp;
			}
			
			// sort
			sort.quickSort(randomArr);
			
			// compare
			for(int i = 0; i < len ; i++)
			{
				if(sorted[i] != randomArr[i])
				{
					System.out.println("ng");
				}
			}
			
		}
		
		System.out.println("ok");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// sortTest(1000, 100000);
				
		if(originalArr == null)
		{
			Random random = new Random();
			
			originalArr = new int[length];
			
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
		
		
		// Merge sort		
		System.out.println("[Merge sort]");
		
		temp = Arrays.copyOf(originalArr, originalArr.length);

		startTime = System.currentTimeMillis();

		sort.mergeSort(temp);
		
		endTime = System.currentTimeMillis();
		
		runTime = (endTime - startTime)/1000.0;
		
		printArr(temp, 20);
		
		System.out.println("runtime:"+runTime+"\n");
		
		// Quick sort		
		System.out.println("[Quick sort]");
		
		temp = Arrays.copyOf(originalArr, originalArr.length);

		startTime = System.currentTimeMillis();

		sort.quickSort(temp);
		
		endTime = System.currentTimeMillis();
		
		runTime = (endTime - startTime)/1000.0;
		
		printArr(temp, 20);
		
		System.out.println("runtime:"+runTime+"\n");
		
	}

}
