public class QuickSort implements SortingAlgorithm
{
	//Sort function calls quicksort and instantiates the first and last indeces.
	public void sort (int[] a)
	{
		quicksort(a, 0, a.length - 1);
	}

	//Quicksort function checks the indeces to see if there's an array to be sorted.
	//Then calls partition to get index of sorted pivot.
	//Then calls itself recursively to continue partitioning but with different indeces every iteration.
	private void quicksort (int[] a, int left, int right) 
	{
		if (left < right) 
		{
			int p = partition(a, left, right);
			quicksort(a, left, p-1);
			quicksort(a, p+1, right);
		}
	}

	//Partition function takes the first element as pivot.
	//Then it checks each element in the array and swaps it to the left if its smaller than the pivot.
	private int partition (int[] a, int left, int right) 
	{
		if (left < right) 
		{
			int pivot = left;
			int i = left + 1; // Avoids re-sorting the pivot
			int j = right;
			while (i < j) 
			{
				while (i <= right && a[i] <= a[pivot]) 
				{
					i++;
				}
				while (j >= i && a[j] > a[pivot]) 
				{
					--j;
				}
				if (i <= right && i < j) 
				{
					swap(a, i, j);
				}
			}
			swap(a, pivot, j);  // pivot to the middle
			return j;
		}
		return left;
	}

	//Swap function switches two array elements.
	private void swap (int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}