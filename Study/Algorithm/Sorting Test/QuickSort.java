
public class QuickSort implements Sort {
	
	private void quickSortInner(int [] arr, int left, int right)
	{
		if(left < right)
		{
			int  d = quickSortPartition(arr, left, right);
			quickSortInner(arr, left, d - 1);
			quickSortInner(arr, d + 1, right);
		}
	}
	
	private int quickSortPartition(int [] arr, int left, int right)
	{
		int pivot = arr[left];
		int low = left + 1;
		int high = right;
		
		while(low <= high)
		{
			while(arr[low] < pivot && low < right) low++;			
			
			while(arr[high] > pivot && high > left) high--;
						
			if(high <= low)
			{
				break;
			}
			else
			{
				int temp = arr[high];
				arr[high] = arr[low];
				arr[low] = temp;
				
				low++;
				high--;
			}			
		}		

		int temp = arr[high];
		arr[high] = arr[left];
		arr[left] = temp;
		
		return high;		
	}
	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		quickSortInner(arr, 0, arr.length - 1);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "QuickSort";
	}

}
