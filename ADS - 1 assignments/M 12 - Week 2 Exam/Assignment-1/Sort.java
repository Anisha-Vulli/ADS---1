import java.util.Arrays;

class Sort {
    public Student[] stuarray = new Student[30];
    public Student[] seatsarray = new Student[30];
    int stucount;
    int seatscount;

    Sort() {
        stucount = 0;
        seatscount = 0;
    }

    void addStudent(Student stugiven) {

        // if (stucount == 10) {
        //  resize();
        // }
        // stuarray[stucount] = stugiven;
        // stucount++;
        try {
            stuarray[stucount++] = stugiven;
            return;
        } catch (Exception e) {
            sturesize();
            //stuarray[stucount++] = stugiven;
        }
        stuarray[stucount++] = stugiven;
    }

    void addseats(Student stueli) {
        try {
            seatsarray[seatscount++] = stueli;
            return;
        } catch (Exception e) {
            seatresize();
            //stuarray[stucount++] = stugiven;
        }
        seatsarray[seatscount++] = stueli;
    }

    void seatresize() {
        seatsarray = Arrays.copyOf(seatsarray, 2 * seatscount);
    }
    void sturesize() {
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
        System.out.println();
        for (int j = 0; j < seatscount; j++) {
            System.out.println(seatsarray[j]);
        }
        return "";
    }

    public void seats(int vacant, int unrev, int bcvac, int scvac, int stvac) {
        //System.out.println("SWALLA");
        int allcount = 0;
        int ucount = 0;
        int bcount = 0;
        int sccount = 0;
        int stcount = 0;
        for (int i = 0; i < stucount; i++) {
            if (allcount == vacant) {
                break;
            }
            if (stcount != stvac) {
                if (stuarray[i].cat.equals("ST")) {
                    addseats(stuarray[i]);
                    stcount++;
                    allcount++;
                }
            }

            if (sccount != scvac) {
                if (stuarray[i].cat.equals("SC")) {
                    addseats(stuarray[i]);
                    sccount++;
                    allcount++;
                }
            }

            if (bcount != bcvac) {
                if (stuarray[i].cat.equals("BC")) {
                    addseats(stuarray[i]);
                    bcount++;
                    allcount++;
                }
            }

            if (ucount != unrev) {
                if (stuarray[i].cat.equals("Open")) {
                    addseats(stuarray[i]);
                    ucount++;
                    allcount++;
                }
            }
        }
    }
}