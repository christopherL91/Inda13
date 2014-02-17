public class Quicksort {
	
	private static class Partition {
		public Partition(int A[],int p,int r) {
			int x = A[r];
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

		private void swap(int[] array, int a, int b) {
			int a0 = array[a];
			array[a] = array[b];
			array[b] = a0; 
		}
	}

	public Quicksort() {
		//do nothing
	}

	public void sort() {
	}
}