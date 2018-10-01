import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
        //Empty constructor.
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Steque sq = new Steque();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            if (data.equals("") || data.equals(null)) {
                sq = new Steque();
                System.out.println("");
            } else {
                String[] input = data.split(" ");
            switch (input[0]) {
                case "push":
                sq.push(Integer.parseInt(input[1]));
                System.out.println(sq);
                break;
                case "pop":
                if (!sq.isEmpty()) {
                    sq.pop();
                    //System.out.println(sq);
                    if (!sq.isEmpty()) {
                        System.out.println(sq);
                    } else {
                        System.out.println("Steque is empty.");
                    }
                } else {
                    System.out.println("Steque is empty.");
                }
                break;
                case "enqueue":
                sq.enque(Integer.parseInt(input[1]));
                System.out.println(sq);
                break;
                default:
                break;
            }
            }
        }
    }
}