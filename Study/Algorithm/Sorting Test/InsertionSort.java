
public class InsertionSort implements Sort {

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "InsertionSort";
	}

}
