import java.util.Arrays;

public class MergeSort implements SortingAlgorithm
{
	//Sort function splits given array into a left and right side.
	//Recursively calls itself to continue splitting the arrays in half.
	//Calls merge to put arrays back together.
	public void sort (int[] a)
	{
		if (a.length > 1)
		{
			int[] left = getLeft(a);
			int[] right = getRight(a);

			sort(left);
			sort(right);

			merge (a, left, right);
		}
	}

	//Merge function merges elements of two arrays together in the correct order.
	private void merge (int[] a, int[] left, int[] right)
	{
		int a_i = 0;			//Index of the array.
		int left_i = 0;			//Index of the left array.
		int right_i = 0;		//Index of the right array.

		//While loop iterates through the array so long as the left/right's index don't go out of bounds.
		while (left_i < left.length && right_i < right.length)
		{
			//If the left element is less than the right element, the left element is assigned into the sorted array. 
			if (left[left_i] <= right[right_i])
			{
				a[a_i] = left[left_i];
				left_i++;
				a_i++;
			}
			//In any other case, the right element is assigned to the sorted array, and both indeces are incremented.
			else
			{
				a[a_i] = right[right_i];
				right_i++;
				a_i++;
			}
		}
		//Last two while-loops merge whatever is remaining in either array.
		while (left_i < left.length)
		{
			a[a_i++] = left[left_i++];
		}
		while (right_i < right.length)
		{
			a[a_i++] = right[right_i++];
		}
	}

	//getLeft function creates an array that goes from 0 to the middle of the given array.
	//The values of the left side of the given array is copied into "left".
	//"Left" is returned.
	private int[] getLeft (int[] a)
	{
		int leftlength = (a.length)/2;
		int[] left = new int[leftlength];

		for (int i = 0; i < leftlength; i++)
		{
			left[i] = a[i];
		}

		return left;
	}

	//getRight function creates an array that starts after the middle of the given array to the given array's end.
	//The values of the right side of the given array is copied into "right".
	//"Right" is returned.
	private int[] getRight (int[] a)
	{
		int leftlength = (a.length)/2;
		int rightlength = a.length - leftlength;
		int[] right = new int [rightlength];

		for (int i = 0; i < (rightlength); i++)
		{
			right[i] = a[i + leftlength];
		}
		
		return right;
	}

}