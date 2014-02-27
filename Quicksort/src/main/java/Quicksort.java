import java.util.Arrays;

public class Quicksort {

	private static final int MIN_RANGE = 50;

//Nested class.
//--------------------------------------------------------
	private static class Partition {
		public static int doPartition(int A[],int first,int last, int p) {
			int pivot = A[p];
			swap(A, p, last);
			int mid = first - 1;
			for (int j = first; j < last; j++) {
				if (A[j] <= pivot) {
					mid +=1;
					swap(A,mid,j);
				}
			}
			swap(A,mid+1,last);
			return mid+1;
		}

		private static void swap(int[] array, int a, int b) {
			int a0 = array[a];
			array[a] = array[b];
			array[b] = a0;
		}
	}
//--------------------------------------------------------


//Insertsionsorting
//--------------------------------------------------------
	//sort and buffer between two indexes.
	public int[] insertsionSort(int buffer[],int first,int last) {
        int j,key,i;

        for (j = first + 1; j < last;j++) {
            key = buffer[j];
            i = j - 1;
                while(i >= first && buffer[i] >= key) {
                    buffer[i + 1] = buffer[i];
                    i--;
                }
            buffer[i + 1] = key;
        }
    	return buffer;
    }
//-----------------------------------------------------------

// Utilities section.
//-----------------------------------------------------------
   /*
   * shamelessly taken from https://stackoverflow.com/questions/7961788/math-random-explained
   */
   private int randomWithRange(int min, int max) {
   int range = (max - min) + 1;
   return (int)(Math.random() * range) + min;
}
// Sorting section.
//-----------------------------------------------------------

    //fixed pivot, min range
    public void quicksort1(int buffer[], int first, int last) {
		if(last-first > MIN_RANGE) {
			insertsionSort(buffer, first, last);
			return;
		}
		if (first < last) {
			int pivotIndex = first+(last-first)/2;
			int mid = Partition.doPartition(buffer,first,last, pivotIndex);
			quicksort1(buffer,first,mid-1);
			quicksort1(buffer,mid+1,last);
		}
	}
	//random pivot, min range
    public void quicksort2(int buffer[], int first, int last) {
		if(last-first > MIN_RANGE) {
			insertsionSort(buffer, first, last);
			return;
		}
		if (first < last) {
			int pivotIndex = randomWithRange(0,buffer.length-1);
			int mid = Partition.doPartition(buffer,first,last, pivotIndex);
			quicksort2(buffer,first,mid-1);
			quicksort2(buffer,mid+1,last);
		}
    }
    ///random pivot, without fallback.
    public void quicksort3(int buffer[], int first, int last) {
		if (first < last) {
			int pivotIndex = randomWithRange(0,buffer.length-1);
			int mid = Partition.doPartition(buffer,first,last, pivotIndex);
			quicksort3(buffer,first,mid-1);
			quicksort3(buffer,mid+1,last);
		}
    }
    //fixed pivot, without fallback.
    public void quicksort4(int buffer[], int first, int last) {
		if (first < last) {
			int pivotIndex = first+(last-first)/2;
			int mid = Partition.doPartition(buffer,first,last, pivotIndex);
			quicksort4(buffer,first,mid-1);
			quicksort4(buffer,mid+1,last);
		}
    }
//-----------------------------------------------------------
}