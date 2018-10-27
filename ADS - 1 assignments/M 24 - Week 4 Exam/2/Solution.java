/**
 * Scanner import.
 */
import java.util.Scanner;

/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * Student name.
     */
    private String name;
    /**
     * Student rollno.
     */
    private int rollno;
    /**
     * Student marks.
     */
    private Double marks;
    /**
     * Constructs the object.
     *
     * @param      rollno1  The rollno 1
     * @param      name1    The name 1
     * @param      marks1   The marks 1
     */
    Student(final int rollno1,
        final String name1, final Double marks1) {
        this.name = name1;
        this.marks = marks1;
        this.rollno = rollno1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets rollnumber.
     *
     * @return     { description_of_the_return_value }
     */
    public int getnum() {
     return this.rollno;
    }
    /**
     * Gets marks.
     *
     * @return     { description_of_the_return_value }
     */
    public Double getmarks() {
        return this.marks;
    }

    /**
     * compare To.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student that) {
        if (this.marks > that.marks) {
            return 1;
        }
        if (this.marks < that.marks) {
            return -1;
        }
        if (this.rollno > that.rollno) {
            return 1;
        }
        if (this.rollno < that.rollno) {
            return -1;
        }
        return 0;
    }
}

/**
 * class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int noinputs = Integer.parseInt(sc.nextLine());
        RedBlackBST<Student, Integer> bst 
        = new RedBlackBST<Student, Integer>();
        Student stu = null;
        for (int i = 0; i < noinputs; i++) {
            String[] input = sc.nextLine().split(",");
            stu = new Student(Integer.parseInt(input[0]),
                input[1], Double.parseDouble(input[2]));
            bst.put(stu, Integer.parseInt(input[0]));
        }
        int num = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < num; j++) {
            String[] tokens = sc.nextLine().split(" ");
            if (tokens[0].equals("BE")) {
                double less = Double.parseDouble(tokens[1]);
                double greater = Double.parseDouble(tokens[2]); 
                for (Student each : bst.keys()) {
                    //System.out.println(each.getName());
                    if (each.getmarks() >= less && each.getmarks() <= greater) {
                        System.out.println(each.getName());
                    }
                }
             } else if (tokens[0].equals("LE")) {
                double value = Double.parseDouble(tokens[1]);
                for (Student each : bst.keys()) {
                    if (each.getmarks() <= value) {
                        System.out.println(each.getName());
                    }
                }
            } else if (tokens[0].equals("GE")) {
                double value = Double.parseDouble(tokens[1]);
                for (Student each : bst.keys()) {
                    if (each.getmarks() >= value) {
                        System.out.println(each.getName());
                    }
                }
            }
        }
    }
}

