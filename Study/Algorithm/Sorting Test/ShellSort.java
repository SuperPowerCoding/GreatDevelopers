
public class ShellSort implements Sort {

	private void partInsertionSort(int[] arr, int start, int last, int gap)
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
	
	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		for(int gap = arr.length / 2; gap > 0 ; gap /= 2)
		{
			if(gap%2 == 0) gap++;
			for(int i = 0 ; i < gap ; i++)
			{
				partInsertionSort(arr,i,arr.length - 1,gap);
			}
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ShellSort";
	}

}
