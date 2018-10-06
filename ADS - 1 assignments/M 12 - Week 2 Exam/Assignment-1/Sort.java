import java.util.Arrays;

class Sort {
	public Student[] stuarray = new Student[10];
	int stucount;

	Sort() {
		stucount = 0;
	}

	void addStudent(Student stugiven) {
		try {
			stuarray[stucount++] = stugiven;
			return;
		} catch (Exception e) {
			resize();
		}
		stuarray[stucount++] = stugiven;
	}

	void resize() {
		stuarray = Arrays.copyOf(stuarray, 2 * stucount);
	}

	void selectionSort() {
		for (int i = 0; i < stucount; i++) {
			int min = i;
			for (int j = i + 1; j < stucount; j++) {
				if (less(stuarray, j, min)) {
					min = j;
				}
			}
			exchange(stuarray, i, min);
		}
	}

	void exchange(Student[] array, int i, int j) {
		Student stu = array[j];
		array[j] = array[i];
		array[i] = stu;
	}

	boolean less(Student[] array, int i, int j) {
		return array[i].compareTo(array[j]) > 0;
	}

	public String toString() {
		for (int i = 0; i < stucount; i++) {
			System.out.println(stuarray[i]);
		}
		return "";
	}
}