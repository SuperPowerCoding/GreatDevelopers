
public class BubbleSort implements Sort {

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "BubbleSort";
	}

}
