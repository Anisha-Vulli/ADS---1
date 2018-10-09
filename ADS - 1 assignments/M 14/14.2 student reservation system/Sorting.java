import java.util.ArrayList;
import java.util.Arrays;
class Sorting {
	Student[] stdarray;
	int size;
	Sorting() {
		stdarray = new Student[40];
		size = 0;
	}

	void addStudent(Student item) {
		stdarray[size++] = item;
		//System.out.println(Arrays.toString(stdarray));
	}

	public void resize() {
		stdarray = Arrays.copyOf(stdarray, 2 * size);
	}

	public int size() {
		return size;
	}

	public String toString() {
		for (int i = 0; i < size; i++) {
			System.out.println(stdarray[i]);
		}
		return "";
	}

	public void sort() {
		int n = size;
		for (int i = n / 2; i >= 1; i--) {
			sink(stdarray, i, n);
		}

		while (n > 1) {
			swap(stdarray, 1, n--);
			sink(stdarray, 1, n);
		}
	}

	public void sink(Student[] array, int k, int n) {
		while(2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(stdarray, j, j + 1)) {
				j++;
			}

			if (!less(stdarray, k, j)) {
				break;
			}

			swap(stdarray, k, j);
			k = j;
		}
	}

	public boolean less(Student[] array, int i, int j) {
		return array[i - 1].compareTo(array[j - 1]) >= 0;
	}

	public void swap(Student[] array, int i, int j) {
		Student temp = array[i - 1];
		array[i - 1] = array[j - 1];
		array[j - 1] = temp;
	}

	public boolean contains(int[] array, int s) {
		for (int i : array) {
			if (s == i) {
				return true;
			}
		}
		return false;
	}

	public void vacancyprint(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(stdarray[i].name + "," + stdarray[i].total + "," + stdarray[i].cat);
		}
	}

	public void vacancy(int open, int bc, int sc, int st) {
		int[] array = new int[bc + sc + st];
		int i = 0;
		int n = open;
		for (int k = n; k < size; k++) {
			if (stdarray[k].cat.equals("BC") && bc > 0) {
				array[i++] = k;
				bc--;
			}

			else if (stdarray[k].cat.equals("SC") && sc > 0) {
				array[i++] = k;
				sc--;
			}

			else if (stdarray[k].cat.equals("ST") && st > 0) {
				array[i++] = k;
				st--;
			}
		}

		if (bc > 0) {
			for (int k = n; k < size; k++) {
				if (stdarray[k].cat.equals("Open") && bc > 0) {
					if (!contains(array, k)) {
						array[i++] = k;
						bc--;
					}
				}
			}
		}

		if (sc > 0) {
			for (int k = n; k < size; k++) {
				if (stdarray[k].cat.equals("Open") && sc > 0) {
					if (!contains(array, k)) {
						array[i++] = k;
						sc--;
					}
				}
			}
		}

		if (st > 0) {
			for (int k = n; k < size; k++) {
				if (stdarray[k].cat.equals("Open") && st > 0) {
					if (!contains(array, k)) {
						array[i++] = k;
						st--;
					}
				}
			}
		}
		Arrays.sort(array);
		for (int k = 0; k < array.length; k++) {
			System.out.println(stdarray[array[k]].toString());
		}
	}

}