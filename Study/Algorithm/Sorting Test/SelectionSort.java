
public class SelectionSort implements Sort {

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SelectionSort";
	}

}
