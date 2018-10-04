import java.util.Scanner;

class Merge {
	int[] array;
	int cutoff = 7;
	Merge() {

	}

	void sort(int[] array) {
		int[] aux = array.clone();
		sort(aux, array, 0, array.length - 1);
	}

	void sort(int[] aux, int[] array, int low, int high) {
		if (high < low + cutoff) {
			insertionsort(aux, low, high);
			System.out.println("Insertion sort method invoked...");
			return;
		}

		int mid = low + (high - low) / 2;
		sort(aux, array, low, mid);
		sort(aux, array, mid + 1, high);
		if (!less(array[mid + 1], array[mid])) {
			for (int i = low; i <= high; i++) {
				aux[i] = array[i];
			}

			System.out.println("Array is already sorted. So, skipped the call to merge...");
			return;
		}

		merge(aux, array, low, mid, high);
	}
	
	void merge(int[] aux, int[] array, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            }

            else if (j > high) {
                array[k] = aux[i++];
            }

            else if (less(aux[j], aux[i])) {
                array[k] = aux[j++];
            }

            else {
                array[k] = aux[i++];
            }
        }
	}

	void insertionsort(int[] array, int low, int high) {
		for (int i = low; i <= high; i++) {
			for (int j = i; j > 0 && less(array[j], array[j - 1]); j++) {
				exchange(array, j, j - 1);
			}
		}
	}

	public  boolean less(int i, int j) {
        return j > i;
    }

    void exchange(int[] array, int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp; 
    }

    public String toString() {
        String str = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[i] + "]";
        return str;
    }
}


class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] inputarr = sc.nextLine().split(",");
			
			int[] srcarr = new int[inputarr.length];
			for (int i = 0; i < inputarr.length; i++) {
				srcarr[i] = Integer.parseInt(inputarr[i]);
			}
			//System.out.println(Arrays.toString(intarr));
			Sort s = new Sort();
			s.sort(srcarr);
			System.out.println(s);
		}
	}
}