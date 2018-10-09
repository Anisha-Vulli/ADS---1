class Student implements Comparable<Student> {
    private String name;
    private String dob;
    private int marks1;
    private int marks2;
    private int marks3;
    private int total;
    private String cat;

    Student(final String name1, final String dob1, final int marks11,
        final int marks22, final int marks33, final int total1,
        final String cat1)  {
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

    public String getname() {
        return name;
    }

    public String getdob() {
        return dob;
    }

    public int getmarks1() {
        return marks1;
    }

    public int getmarks2() {
        return marks2;
    }

    public int getmarks3() {
        return marks3;
    }

    public int gettotal() {
        return total;
    }

    public String getcat() {
        return cat;
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