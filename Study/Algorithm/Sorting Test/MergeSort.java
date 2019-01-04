
public class MergeSort implements Sort {
	static int[] mergeSortedArr;
	private void mergeSortDivide(int[] arr, int left, int right)
	{
		if(left < right)
		{
			int mid = left + (right - left)/2+1;
			
			mergeSortDivide(arr, left,mid-1);
			mergeSortDivide(arr, mid,right);
			mergeSortMerge(arr, left, mid, right);
		}
	}
	
	private void mergeSortMerge(int[] arr, int left, int mid, int right )
	{
		int i,j,k;
		i = left;
		j = mid;
		k = i;

		while(i < mid && j <= right)
		{
			mergeSortedArr[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
		}
		
		// 남은 부분을 복사
		if( i < mid)
		{
			for( ; i < mid ; i++)
			{
				mergeSortedArr[k++] = arr[i];
			}
		}
		else
		{
			for( ; j <= right ; j++)
			{
				mergeSortedArr[k++] = arr[j];
			}
		}
		
		for(k = left ; k <= right ; k++)
		{
			arr[k] = mergeSortedArr[k];
		}

	}
	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		mergeSortedArr = new int[arr.length];
		mergeSortDivide(arr, 0, arr.length - 1);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "MergeSort";
	}

}
