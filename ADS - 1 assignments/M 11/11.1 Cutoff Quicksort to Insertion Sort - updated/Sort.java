class Sort {
	Sort() {
	}

	public int partition(Comparable[] array, int low, int high) {
		int i = low;
		int j = high + 1;
		while (true) {
			while (less(array[++i], array[low])) {
				if (i == high) {
					break;
				}
			}

			while (less(array[low], array[--j])) {
				if (j == low) {
					break;
				}
			}

			if (i >= j) {
				break;
			}

			exchange(array, i, j);
		}

		exchange(array, low, j);
		System.out.println(toString(array));
		return j;
	}


	public void quickSort(Comparable[] array, int low, int high, int cutoff) {
		if (high <= low + cutoff - 1) {
			insertionSort(array, low, high);
			System.out.println("insertionSort called");
			return;
		}

		int j = partition(array, low, high);
		quickSort(array, low, j - 1, cutoff);
		quickSort(array, j + 1, high, cutoff);
	}

	public void quickSort(Comparable[] array, int cutoff) {
		quickSort(array, 0, array.length - 1, cutoff);
	}

	public void insertionSort(Comparable[] array, int low, int high) {
		for (int i = low; i <= high; i++) {
			for (int j = i; j > low && less(array[j], array[j - 1]); j--) {
				exchange(array, j, j - 1);
			}
		}
	}

	public void exchange(Comparable[] array, int i, int j) {
		Comparable swap = array[i];
		array[i] = array[j];
		array[j] = swap;
	}

	public boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public Object toString(Object[] a) {
		String s = "[";
		int i;
		for (i = 0; i < a.length - 1; i++) {
			s += a[i] + ", ";
		}

		s += a[a.length - 1] + "]";
		return s;
	}

}