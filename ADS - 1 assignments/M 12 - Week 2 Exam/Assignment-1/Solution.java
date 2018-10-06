import java.util.Scanner;
import java.util.Arrays;
class Solution {
    
    public static Student createStu(final String[] studentdet) {
        String name = studentdet[0];
        String dob = studentdet[1];
        int marks1 = Integer.parseInt(studentdet[2]);
        int marks2 = Integer.parseInt(studentdet[3]);
        int marks3 = Integer.parseInt(studentdet[4]);
        int total = Integer.parseInt(studentdet[5]);
        String cate = studentdet[6];
        return new Student(name, dob, marks1, marks2, marks3, total, cate);
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sort s = new Sort();
        int stuQua = Integer.parseInt(sc.nextLine());
        int vacant = Integer.parseInt(sc.nextLine());
        int unrev = Integer.parseInt(sc.nextLine());
        int bcvac = Integer.parseInt(sc.nextLine());
        int scvac = Integer.parseInt(sc.nextLine());
        int stvac = Integer.parseInt(sc.nextLine());
        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(",");
            //System.out.println(Arrays.toString(input));
            s.addStudent(createStu(input));
        }

        s.selectionSort();
        s.seats(vacant, unrev, bcvac, scvac, stvac);
        System.out.println(s);
    }
}