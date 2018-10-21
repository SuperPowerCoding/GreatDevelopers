
public class Sort {
		
	public void selectionSort(int[] arr)
	{
		for(int i = 0 ; i < arr.length - 1; i++)
		{
			int min = arr[i];
			int minIdx = i;
			for(int j = i + 1;j < arr.length; j++)
			{
				if(min > arr[j])
				{
					min = arr[j];
					minIdx = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
				
		}
	}
	
	public void insertionSort(int[] arr)
	{
		for(int i = 1 ; i <arr.length; i++)
		{
			/* 비효율적
			for(int j = 0 ;j < i; j++)
			{
				if(arr[i] < arr[j])
				{
					int insert = arr[i];
					for(int k = i; k > j; k--)
					{
						arr[k] = arr[k - 1];
					}
					arr[j] = insert;
					break;
				}				
			}
			*/
			int key = arr[i];
			int j = i-1;
			for(; j >=0 && arr[j] > key ; j--)
			{
				arr[j+1] = arr[j];
			}
			arr[j+1] = key;
		}
	}
		
	
	public void bubbleSort(int[] arr)
	{
		for(int i = arr.length - 1; i > 0; i--)
		{
			for(int j = 0; j < i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
		}
	}
	
	
	/*
	 *  Shell Sort
	 */
	
	public void partInsertionSort(int[] arr, int start, int last, int gap)
	{
		for(int i = start + gap; i <= last; i += gap)
		{			
			int key = arr[i];
			int j = i - gap;
			for(; j >= start && arr[j] > key ; j -= gap)
			{
				arr[j + gap] = arr[j];
			}
			arr[j + gap] = key;
		}
	}	
	
	public void shellSort(int[] arr)
	{	
		for(int gap = arr.length / 2; gap > 0 ; gap /= 2)
		{
			if(gap%2 == 0) gap++;
			for(int i = 0 ; i < gap ; i++)
			{
				partInsertionSort(arr,i,arr.length - 1,gap);
			}
		}
	}
	
	
}
