public class Quicksort {
	
	private static class Partition {
		public static int doPartition(int A[],int p,int r) {
			int x,i;
			x = A[r];
			i = p - 1;
			for (int j = p; j <= r - 1; j++) {
				if (A[j] <= x) {
					i +=1;
					swap(A,A[i],A[j]);
				}
			swap(A,A[i+1],A[r]);
			}
		return i+1;
		}

		private static void swap(int[] array, int a, int b) {
			int a0 = array[a];
			array[a] = array[b];
			array[b] = a0; 
		}
	}

	public Quicksort() {
		//do nothing
	}

	public static void main(String[] args) {
		Quicksort sorting = new Quicksort();
		int buffer[] = {3,3,2,1};
		int lastIndex = buffer.length - 1;
		int pivot = buffer.length / 2;
		sorting.sort(buffer,pivot,lastIndex);
		System.out.println(buffer);
	}

	public void sort(int Array[],int pivot,int last) {
		if (pivot < last) {
			int q = Partition.doPartition(Array,pivot,last);
			sort(Array,1,Array.length);
		}
	}
}