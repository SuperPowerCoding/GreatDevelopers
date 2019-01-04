import java.util.Arrays;
import java.util.Random;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort[] sort = {
				new InsertionSort(),
				new BubbleSort(),
				new MergeSort(),
				new QuickSort(),
				new SelectionSort(),
				new ShellSort()
		};
		
		Random random = new Random();
		 
		int length = 100000;
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
		
		
		for(Sort s : sort)
		{
			int[] temp;
			long startTime;
			long endTime;
			double runTime;
			System.out.print(s.getName()+":");
			temp = Arrays.copyOf(originalArr, originalArr.length);
			startTime = System.currentTimeMillis();
			s.sort(temp);
			endTime = System.currentTimeMillis();			
			runTime = (endTime - startTime)/1000.0;
			System.out.println(runTime);
		}
		
		
		
	}

}
