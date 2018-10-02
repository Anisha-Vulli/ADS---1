/**
 * Scanner method.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {
        //Empty constructor.
    }
    /**
     * Creates a team.
     *
     * @param      array  The array
     *
     * @return     { description_of_the_return_value }
     */
    public static Team createTeam(final String[] array) {
        String name = array[0];
        //System.out.println(name);
        int wins = Integer.parseInt(array[1]);
        int losses = Integer.parseInt(array[2]);
        int draws = Integer.parseInt(array[2 + 1]);
        return new Team(name, wins, losses, draws);
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Sort s = new Sort();
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(",");
            s.addTeam(createTeam(input));

        }
        //System.out.println(s);
        s.Selectionsort();
        System.out.println(s);
    }
}
