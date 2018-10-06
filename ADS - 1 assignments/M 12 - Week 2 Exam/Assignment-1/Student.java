class Student implements Comparable<Student> {
    String name;
    String dob;
    int marks1;
    int marks2;
    int marks3;
    int total;
    String cat;

    Student(String name1, String dob1, int marks11, int marks22, int marks33, int total1, String cat1)  {
        this.name = name1;
        this.dob = dob1;
        this.marks1 = marks11;
        this.marks2 = marks22;
        this.marks3 = marks33;
        this.total = total1;
        this.cat = cat1;
    }

    public String toString() {
        return name + "," + total +"," + cat;
    }

    public int compareTo(Student that) {
        if (this.total > that.total) {
            return 1;
        }

        if (this.total < that.total) {
            return -1;
        }

        if (this.marks3 > that.marks3) {
            return 1;
        }

        if (this.marks3 < that.marks3) {
            return -1;
        }

        if (this.marks2 > that.marks2) {
            return 1;
        }

        if (this.marks2 < that.marks2) {
            return -1;
        }

        String[] date1 = this.dob.split("-");
        String[] date2 = that.dob.split("-");

        if (Integer.parseInt(date1[2]) > Integer.parseInt(date2[2])) {
            return 1;
        }

        if (Integer.parseInt(date1[2]) < Integer.parseInt(date2[2])) {
            return -1;
        }

        if (Integer.parseInt(date1[1]) > Integer.parseInt(date2[1])) {
            return 1;
        }

        if (Integer.parseInt(date1[1]) < Integer.parseInt(date2[1])) {
            return -1;
        }

        if (Integer.parseInt(date1[0]) > Integer.parseInt(date2[0])) {
            return 1;
        }

        if (Integer.parseInt(date1[0]) < Integer.parseInt(date2[0])) {
            return -1;
        }

        return 0;
    }
}