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

    public void seats(int vacant, int open, int bc, int sc, int st) {
        int allcount = 0;
        for (int j = 0; j < stucount && vacant >= 0; j++) {
            if (stuarray[j].cat.equals("BC") || bc > 0) {
                addseats(stuarray[j]);
                allcount++;
                bc--;
                vacant--;
            }

            else if (stuarray[j].cat.equals("SC") || sc > 0) {
                addseats(stuarray[j]);
                allcount++;
                sc--;
                vacant--;
            }

            else if (stuarray[j].cat.equals("ST") || st > 0) {
                addseats(stuarray[j]);
                allcount++;
                st--;
                vacant--;
            }
        }

        //System.out.println(vacant);
        for (int i = 0; i < stucount && vacant >= 0; i++) {
            if (stuarray[i].cat.equals("Open") && open > 0) {
                addseats(stuarray[i]);
                open--;
                allcount++;
                vacant--;   
            }
        }
        //System.out.println("SWALLA");
        // int allcount = 0;
        // int ucount = 0;
        // int bcount = 0;
        // int sccount = 0;
        // int stcount = 0;
        // for (int i = 0; i < stucount; i++) {
        //     if (allcount == vacant) {
        //         break;
        //     }
        //     if (stcount != stvac) {
        //         //System.out.println("ST");
        //         if (stuarray[i].cat.equals("ST")) {
        //             addseats(stuarray[i]);
        //             allcount++;
        //             stcount++;
        //         }
        //     }

        //     if (sccount != scvac) {
        //         //System.out.println("SC");
        //         if (stuarray[i].cat.equals("SC")) {
        //             addseats(stuarray[i]);
        //             allcount++;
        //             sccount++;
        //         }
        //     }

        //     if (bcount != bcvac) {
        //         //System.out.println("BC");
        //         if (stuarray[i].cat.equals("BC")) {
        //             addseats(stuarray[i]);
        //             allcount++;
        //             bcount++;
        //         }
        //     }

        //     if (ucount != unrev) {
        //         //System.out.println("Open");
        //         if (stuarray[i].cat.equals("Open")) {
        //             addseats(stuarray[i]);
        //             allcount++;
        //             ucount++;
        //         }
        //     }
        // }
    }
}