public class InsertionSort implements SortingAlgorithm 
{
	//Sort function splits array into two sublists through the for- and while- loops.
	public void sort (int[] a)
	{
		for (int i = 1; i < a.length; i++)
		{
			int temp = a[i];
			int j = i - 1;
			//Enters loop if a number in the sorted sublist is greater than one in the unsorted sublist.
			while (j >= 0 && a[j] > temp)
			{
				//Larger number in sorted sublist is moved over (to the right).
				a[j + 1] = a[j];
				j = j - 1;
			}
			//Smaller number is inserted into sorted sublist.
			a[j + 1] = temp;
		}
	}
}